package connectivity;

import org.apache.commons.lang.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import randomForest.KindOfUserEnum;
import randomForest.RandomForestAnalysis;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class MyWeberver {
    public static int port = 8080;
    private long pocket=0;
    private long calling=0;
    private long niu = 0;
    private long iu=0;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
    private RandomForestAnalysis randomForestAnalysis = new RandomForestAnalysis();

    public void parseAndStoreJSON(String json) throws JSONException, IOException, ParseException {
        JSONObject json_object = new JSONObject(json);

        String id = json_object.getString("id");

        //création des fichiers
        File tmp_day_data_file = new File(id+"_tmp_day.data");
        File global_data_file = new File(id+"global_data.data");

        if(global_data_file.createNewFile()) {
            System.out.println("Global data file is created!");
        }

        if (tmp_day_data_file.createNewFile()){
            System.out.println("Temporary file is created!");
            writeDataWhenNothing(tmp_day_data_file,json_object);
        }
        else {
            System.out.println("File already exists.");
            BufferedReader reader = new BufferedReader(new FileReader(tmp_day_data_file));
            reader.readLine();
            pocket = Long.parseLong(reader.readLine());
            calling = Long.parseLong(reader.readLine());
            niu = Long.parseLong(reader.readLine());
            iu = Long.parseLong(reader.readLine());
            reader.close();

            Date tmp_date = getDateFromTmpFile(tmp_day_data_file);
            if(tmp_date ==null) {
                System.out.println("blou");
            }
            JSONArray array_json = json_object.getJSONArray("value");
            for (int i = 0; i < array_json.length()-1; i++) {
                JSONObject datas = array_json.getJSONObject(i);
                JSONObject datas_apres = array_json.getJSONObject(i+1);

                String datestr = datas.getString("day");
                Date date = sdf.parse(datestr);
                System.out.println("datestr");


                String datestr_apres = datas_apres.getString("day");
                Date date_apres = sdf.parse(datestr_apres);
                System.out.println("datestr_apres");

                if(tmp_date.getDay() != date.getDay() && tmp_date.getDay() == date.getMonth()) {
                    //si la date stockée et date sont différentes,
                    // on fait un random forest sur tmp_date
                    String day = new SimpleDateFormat("EE").format(tmp_date);
                    String prediction = randomForestAnalysis.basicPrediction(pocket,calling,niu,iu);
                    // on stocke le résultat dans le fichier global de l'utilisateur
                    FileWriter writer = new FileWriter(global_data_file,true);
                    writer.write(prediction+","+day+","+pocket+","+calling+","+niu+","+iu+"\n");
                    writer.close();
                    //on change la date stockée par date
                    tmp_date = date;
                    FileWriter writer2 = new FileWriter(tmp_day_data_file,false);
                    writer2.write(datestr+"\n0\n0\n0\n0");
                    writer2.close();
                    pocket = 0;
                    iu = 0;
                    niu = 0;
                    calling = 0;
                    //on ajoute les valeurs de datas aux valeurs existantes sans se poser de questiosn existentielles
                    long l = date_apres.getTime()-date.getTime();//possiblement date et date_apres != mais fuck it

                    String kind = datas.getString("kind");
                    if(kind.equals("NIU_POCKET"))
                        pocket+=l;
                    else if(kind.equals("IU_CALLING"))
                        calling+=l;
                    else if(kind.equals("NIU"))
                        niu+=l;
                    else if(kind.equals("IU"))
                        iu+=l;
                }
                else if(date.getDay() == date_apres.getDay()) {
                    //si on est toujours sur le même jour
                    //on ajoute les valeurs de datas aux valeurs existantes sans se poser de questiosn existentielles
                    long l = date_apres.getTime()-date.getTime();//possiblement date et date_apres != mais fuck it

                    String kind = datas.getString("kind");
                    if(kind.equals("NIU_POCKET"))
                        pocket+=l;
                    else if(kind.equals("IU_CALLING"))
                        calling+=l;
                    else if(kind.equals("NIU"))
                        niu+=l;
                    else if(kind.equals("IU"))
                        iu+=l;
                }
                else {
                    //si on a changé de jour entre date et date_apres
                    //on ajoute les valeurs de datas aux valeurs existantes sans se poser de questions exisitentielles
                    long l = date_apres.getTime()-date.getTime();//possiblement date et date_apres != mais fuck it

                    String kind = datas.getString("kind");
                    if(kind.equals("NIU_POCKET"))
                        pocket+=l;
                    else if(kind.equals("IU_CALLING"))
                        calling+=l;
                    else if(kind.equals("NIU"))
                        niu+=l;
                    else if(kind.equals("IU"))
                        iu+=l;
                    // on fait un random forest sur date
                    String day = new SimpleDateFormat("EE").format(date);

                    System.out.println("bloublou "+pocket+" "+calling+" "+niu+" "+iu);

                    String prediction = randomForestAnalysis.basicPrediction(pocket,calling,niu,iu);
                    // on stocke le résultat dans le fichier global de l'utilisateur
                    FileWriter writer = new FileWriter(global_data_file,true);
                    writer.write(prediction+";"+day+";"+pocket+";"+calling+";"+niu+";"+iu+"\n");
                    writer.close();
                    //on change la date stockée par date_apres
                    tmp_date = date_apres;
                    FileWriter writer2 = new FileWriter(tmp_day_data_file,false);
                    writer2.write(datestr_apres+"\n0\n0\n0\n0");
                    iu = 0;
                    niu = 0;
                    pocket = 0;
                    calling = 0;
                    writer2.close();
                }
            }

            String tmp_str = sdf.format(tmp_date);
            FileWriter writer = new FileWriter(tmp_day_data_file,false);
            writer.write(tmp_str+"\n"+pocket+"\n"+calling+"\n"+niu+"\n"+iu+"\n");
            writer.close();
        }
    }

    public void writeDataWhenNothing(File file, JSONObject json_object) throws JSONException, ParseException, IOException {
        String dateToday = json_object.getString("dateToday");
        JSONArray array_json = json_object.getJSONArray("value");

        for (int i = 0; i < array_json.length()-1; i++) {//TODO on oublie le dernier (toujours d'actualité ou pas?....)
            JSONObject datas = array_json.getJSONObject(i);
            JSONObject datas_apres = array_json.getJSONObject(i+1);

            System.out.println("datestr");
            String datestr = datas.getString("day");
            Date date = sdf.parse(datestr);

            System.out.println("datestr_apres");
            String datestr_apres = datas_apres.getString("day");
            Date date_apres = sdf.parse(datestr_apres);

            long l = date_apres.getTime()-date.getTime();

            String kind = datas.getString("kind");
            if(kind.equals("NIU_POCKET"))
                pocket+=l;
            else if(kind.equals("IU_CALLING"))
                calling+=l;
            else if(kind.equals("NIU"))
                niu+=l;
            else if(kind.equals("IU"))
                iu+=l;
        }

        FileWriter writer = new FileWriter(file,false);
        writer.write(dateToday+"\n"+pocket+"\n"+calling+"\n"+niu+"\n"+iu+"\n");
        writer.close();
    }

    public Date getDateFromTmpFile(File file) {
        Date result = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File wasn't found!");
        }
        String date_str = null;
        try {
            date_str = reader.readLine();
        } catch (IOException e) {
            System.out.println("Couldn't read line from file!");
        }
        try {
            result = sdf.parse(date_str);
        } catch (ParseException e) {
            System.out.println("First line is not a date!");
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

//TODO check type of operation in main for doing this
    public String getKindOfUserFromDate(String json) throws JSONException, ParseException, IOException {
        String result = "";

        JSONObject json_object = new JSONObject(json);
        String id = json_object.getString("id");
        String date_str = json_object.getString("date");

        Date date = sdf.parse(date_str);
        String day = new SimpleDateFormat("EE").format(date);

        //fichier global
        File global_data_file = new File(id+"global_data.data");
        if(global_data_file!=null) {

            BufferedReader reader = new BufferedReader(new FileReader(global_data_file));
            String tmp = reader.readLine();

            int[] result_proba_tab = {0,0,0,0,0};
            while(tmp!=null ) {
                String[] tab = tmp.split(";");
                String d = tab[1];
                if(day.equals(d)) {
                    String proba = getProbaFromString(tab[0]);
                    switch (proba) {
                        case "caller":
                            result_proba_tab[0]++;
                            break;
                        case "idle_user":
                            result_proba_tab[1]++;
                            break;
                        case "player":
                            result_proba_tab[2]++;
                            break;
                        case "pocket_user":
                            result_proba_tab[3]++;
                            break;
                        case "equilibrate_user":
                            result_proba_tab[4]++;
                            break;
                    }

                }
                tmp = reader.readLine();
            }
            List<Integer> b = Arrays.asList(ArrayUtils.toObject(result_proba_tab));
            int max = Collections.max(b);
            if(max ==result_proba_tab[0])
                result = KindOfUserEnum.CALLER.getTxt();
            else if(max ==result_proba_tab[1])
                result = KindOfUserEnum.IDLE_USER.getTxt();
            else if(max ==result_proba_tab[2])
                result = KindOfUserEnum.PLAYER.getTxt();
            else if(max ==result_proba_tab[3])
                result = KindOfUserEnum.POCKET_USER.getTxt();
            else if(max ==result_proba_tab[4])
                result = KindOfUserEnum.EQUILIBRATE.getTxt();
        }
        return result;
    }

    public String getProbaFromString(String string) {
        //TODO
        float player = -1;
        float caller = -1;
        float idle = -1;
        float pocket = -1;
        //type de la chaine : {assoc=VAL, caller=VAL, idle_user=VAL, pocket_user=VAL}
        //VAL à 18 caractères
        string = string.replace("{caller=","");
        string = string.replace(", idle_user=,","");
        string = string.replace(", player=","");
        string = string.replace(", pocket_user=","");
        string = string.replace("}","");

        caller = Integer.parseInt(string.substring(0,17));
        idle = Integer.parseInt(string.substring(18,35));
        player = Integer.parseInt(string.substring(36,53));
        pocket = Integer.parseInt(string.substring(54,71));

        //ces deux string devraient être identiques
        System.out.println(string);
        System.out.println(caller+idle+player+pocket+"");

        if(pocket>player && pocket>caller && pocket>idle)
            return KindOfUserEnum.POCKET_USER.getTxt();

        else if(idle>player && idle>caller && idle>pocket)
            return KindOfUserEnum.IDLE_USER.getTxt();

        else if(player+caller>0.5)
            return KindOfUserEnum.CALLER.getTxt();

        else if(player>caller && player>idle && player>pocket)
            return KindOfUserEnum.PLAYER.getTxt();

        else
            return KindOfUserEnum.EQUILIBRATE.getTxt();
    }
}