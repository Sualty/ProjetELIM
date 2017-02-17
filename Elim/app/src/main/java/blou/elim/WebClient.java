package blou.elim;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by blou on 28/12/16.
 */

//TODO utiliser ce client dans mainactivity pour
//TODO - envoyer les données du capteur quand on a accès à internet et sinon stocker en bdd locale
//TODO - envoyer  les données de la bdd dès qu'on récupère internet
public class WebClient extends AsyncTask<String, Integer, Long> {
    public static final String SERVERIP = "192.168.43.168"; //your computer IP address
    public static final int SERVERPORT = 8080;

    public MainActivity ma;

    private PrintWriter out;
    private BufferedReader in;

    public WebClient(MainActivity ma){
        this.ma = ma;
    }

    public void sendData(String json){
        Log.d("SEND DATA", "BEFORE");
        out.println(json);
        out.flush();
//        if (out != null && !out.checkError()) {
//            Log.d("SEND DATA", "AFTER");
//            out.println(json);
//            out.flush();
//        }
    }

    @Override
    public Long doInBackground(String... arg0) {
        Log.d("WEB SERVER", "RUN METHOD");
        try {
            InetAddress serverAddr = InetAddress.getByName(SERVERIP);

            Log.e("CONNECTING", SERVERIP);

            Socket socket = new Socket(serverAddr, SERVERPORT);

            try {
                //sending json of datas
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                Log.d("OUT", "out has bee done");
                //getting back response from server
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Log.d("TMP", "avant read line");
                //Log.d("STRING STOCKEE",tmp);
                Log.d("TMP", "après read line");
                String tmp = in.readLine();
                //Log.d("reponse", tmp + "bloubloublou");
                while (tmp != null) {
                    tmp = in.readLine();
                    Log.d("reponse", tmp + "bloubloublou");
                    ma.toastPrediction(tmp);
                }
            } catch (Exception e) {
                Log.e("EXCEPTION", e.toString());
            } finally {
                socket.close();
            }

        } catch (Exception e) {
            Log.e("EXCEPTION", e.toString());
        }

        return null;
    }
}
