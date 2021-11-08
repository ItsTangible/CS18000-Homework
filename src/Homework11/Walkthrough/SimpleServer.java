package Homework11.Walkthrough;

import java.io.*;
import java.net.*;
/**
 * Simple Server
 *
 * @author Benjamin W.
 *
 * @version 11/8/21
 */
public class SimpleServer {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {

        /* The server will run and wait for a client to connect.
         * It will do so using a ServerSocket. The ServerSocket allows us to
         * wait for the client connection to come through:
         */
        ServerSocket serverSocket = new ServerSocket(4242);

        /* Notice that we use the same port for both the server and the client.
         * The accept() method will wait until the client connects. We will use
         * the Socketobject to interact with the client.
         */
        System.out.println("Waiting for the client to connect...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        /* The rest of the server code is a rearranged version of the client code,
         * as we are performing very similar tasks:
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());

        String message = reader.readLine();
        System.out.printf("Received from client:\n%s\n", message);


        String response = message.replaceAll(" ",",");


        writer.write(response);
        writer.println();
        writer.flush(); // Ensure data is sent to the client.
        System.out.printf("Sent to client:\n%s\n", response);

        writer.close();
        reader.close();

    }
}
