package connectivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by blou on 29/01/17.
 */
public class Main {

    public static void main(String args[]) {
        try {
            MyWeberver myWeberver = new MyWeberver();
            ServerSocket ss = new ServerSocket(myWeberver.port);
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
                        myWeberver.parseAndStoreJSON(result);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
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
