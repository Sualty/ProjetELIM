package connectivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


//TODO ce serveur renvoie ce qu'a envoyé le tel ; faudrait qu'il fasse autre chose ; définir les communications
public class WebServer {

    private static int port = 8080;

    public static void parseAndStoreJSON(String json) throws JSONException, IOException, ParseException {

        long pocket=0;
        long calling=0;
        long niu = 0;
        long iu=0;
        JSONObject json_object = new JSONObject(json);

        String id = json_object.getString("id");//TODO

        File file = new File(id+".txt");
        if (file.createNewFile()){
            System.out.println("File is created!");
        }
        else{
            System.out.println("File already exists.");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            pocket = Long.parseLong(reader.readLine());
            calling = Long.parseLong(reader.readLine());
            niu = Long.parseLong(reader.readLine());
            iu = Long.parseLong(reader.readLine());
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");

        JSONArray array_json = json_object.getJSONArray("value");//TODO
        for (int i = 0; i < array_json.length()-1; i++) {//TODO on oublie le dernier
            JSONObject datas = array_json.getJSONObject(i);
            JSONObject datas_apres = array_json.getJSONObject(i+1);

            String datestr = datas.getString("day");
            Date date = sdf.parse(datestr);

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
        writer.write(pocket+"\n"+calling+"\n"+niu+"\n"+iu+"\n");
        writer.close();
    }

    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(port);
            for (;;) {
                // Wait for a client to connect. The method will block;
                // when it returns the socket will be connected to the client
                Socket client = ss.accept();
                System.out.println("New client");

                // Get input and output streams to talk to the client
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream());

                String result="";
                while((result = in.readLine()) != null){
                    System.out.println("Data : " + result);
                    try{
                        parseAndStoreJSON(result);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

                parseAndStoreJSON(result);

                System.out.println(result);
                out.close(); // Flush and close the output stream
                in.close(); // Close the input stream
                client.close(); // Close the socket itself
            }
        }
        catch (Exception e) {
            System.err.println(e);
            System.err.println("Usage: java HttpMirror <port>");
        }
    }
}