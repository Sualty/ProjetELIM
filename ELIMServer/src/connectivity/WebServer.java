package connectivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//TODO ce serveur renvoie ce qu'a envoyé le tel ; faudrait qu'il fasse autre chose ; définir les communications
public class WebServer {
    private static int port = 8080;
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

                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Data : " + line);
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