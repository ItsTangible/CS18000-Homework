package Homework11.Walkthrough;

import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 * Simple Client
 *
 * @author Benjamin W.
 *
 * @version 11/8/21
 */
public class SimpleClient {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);

        /* A Socket is a point at which two machines can connect and communicate.
         * On the client side, we use a Socket to determine where the server is
         * (IP Address) and how we are connecting (port number).
         */
        Socket socket = new Socket("localhost", 4242);

        /* Instead of reading from and writing to a file, we use the socket's connection
         * to the server to write to it. You were taught in class how to use a FileReader
         * object with a BufferedReader object. But, a FileReader object can only read
         * from a file. In this case we are using InputStreamReader which can read from
         * any stream ... even a stream coming from a Socket.
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());

        //Let's begin with receiving the message the user wants to send. This will look familiar:
        System.out.println("What do you want to send to the server?");
        String response = scan.nextLine();

        /* To send the message to the server, we will use our PrintWriter:
         *  - The first line sends the message.
         *  - The second line sends a newline character (system dependent).
         *  - The third line flushes the writer.
         * This step is critical to ensure the data is actually sent to the server.
         * When you call flush(), you guarantee that the message you want to send is
         * sent immediately, rather than being stored in an internal buffer.
         */
        writer.write(response);
        writer.println();
        writer.flush();
        System.out.printf("Sent to the server:\n%s\n", response);

        // With the message sent, all that remains is to wait for a response:
        String s1 = reader.readLine();

        // Once the message comes in, we will print it to see what processing was performed
        System.out.printf("Received from server:\n%s\n", s1);

        writer.close();
        reader.close();
    }
}
