package blou.elim;

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

//TODO vérifier que ça marche x3
//TODO utiliser ce client dans mainactivity pour
//TODO - envoyer les données du capteur quand on a accès à internet et sinon stocker en bdd locale
//TODO - envoyer  les données de la bdd dès qu'on récupère internet
public class WebClient {
    public static final String SERVERIP = "192.168.43.168"; //your computer IP address
    public static final int SERVERPORT = 8080;

    private PrintWriter out;
    private BufferedReader in;

    public void sendData(String json){
        if (out != null && !out.checkError()) {
            out.println(json);
            out.flush();
        }
    }

    public void run() {
        try {
            InetAddress serverAddr = InetAddress.getByName(SERVERIP);

            Log.e("CONNECTING", SERVERIP);

            Socket socket = new Socket(serverAddr, SERVERPORT);

            try {
                //sending json of datas
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

                //getting back response from server
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String tmp = in.readLine();
                while (tmp!=null) {
                    Log.d("SERVER RESPONSE",tmp);
                    tmp= in.readLine();
                }
            }
            catch (Exception e) {
                Log.e("EXCEPTION", e.toString());
            }
            finally {
                socket.close();
            }

        }
        catch (Exception e) {
            Log.e("EXCEPTION", e.toString());
        }

    }
}
