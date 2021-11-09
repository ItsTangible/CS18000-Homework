package Homework11.Challenge;

import javax.swing.*;
import java.io.*;
import java.net.*;
/**
 * Statistics Client
 * A Client that connects to a server with the port number: 6429
 *
 * @author Benjamin W.
 *
 * @version 11/8/21
 */
public class StatisticsClient {

    private static final String title = "Statistics Client";
    private static final String welcomeMessage = "Welcome to the Statistics Client!";
    private static final String hostNamePrompt = "Enter the host name:";
    private static final String portNumberPrompt = "Enter the port number:";
    private static final String connectionEstablished = "Successfully connected to the server!";
    private static final String errorNoConnection = "Error! Could not connect to the server.";
    private static final String enterString = "Enter a string to see its statistics:";
    private static final String errorEmptyString = "Error! String can not be empty.";
    private static final String goAgain = "Would you like to see the statistics for another String?";

    public static void main(String[] args) {

        showWelcomeMessage();

        String host = showEnterHostName();
        int port = showEnterPortNumber();

        try {
            Socket socket = new Socket(host, port);

            showConnectionEstablished();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());


            boolean again = false;
            do {
                String response = "";
                do {
                    response = showEnterString();
                    if (response.isEmpty()) {
                        showErrorEmptyString();
                    }
                } while (response.isEmpty());

                writer.write(response);
                writer.println();
                writer.flush();

                String stats =  "";
                reader.mark(20);
                do {
                    reader.reset();
                    stats += reader.readLine() + "\n";
                    reader.mark(10);
                } while (!reader.readLine().isBlank() || !reader.readLine().isEmpty());

                showStatistics(stats);

                again = showEnterAnotherString();
            } while (again);

            writer.close();
            reader.close();

        } catch (Exception e) {
            showConnectionNotEstablished();
        }
    }

    public static void showWelcomeMessage() {
        JOptionPane.showMessageDialog(null, welcomeMessage,
                title,JOptionPane.INFORMATION_MESSAGE );

    }

    public static String showEnterHostName() {
        String portName = JOptionPane.showInputDialog(null,
                hostNamePrompt, title, JOptionPane.QUESTION_MESSAGE);
        return portName;
    }

    public static int showEnterPortNumber() {
        int portNumber = Integer.parseInt(JOptionPane.showInputDialog(null,
                portNumberPrompt, title, JOptionPane.QUESTION_MESSAGE));
        return portNumber;
    }

    public static void showConnectionEstablished() {
        JOptionPane.showMessageDialog(null, connectionEstablished,
                title,JOptionPane.INFORMATION_MESSAGE );
    }

    public static void showConnectionNotEstablished() {
        JOptionPane.showMessageDialog(null, errorNoConnection,
                title, JOptionPane.ERROR_MESSAGE);
    }

    public static String showEnterString() {
        String s = JOptionPane.showInputDialog(null,
                enterString, title, JOptionPane.QUESTION_MESSAGE);
        return s;
    }

    public static void showErrorEmptyString() {
        JOptionPane.showMessageDialog(null, errorEmptyString,
                title, JOptionPane.ERROR_MESSAGE);
    }

    public static void showStatistics(String stats) {
        JOptionPane.showMessageDialog(null, stats,
                title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean showEnterAnotherString() {
        int again = JOptionPane.showConfirmDialog(null, goAgain, title, JOptionPane.YES_NO_OPTION);
        if (again == 0) {
            return true;
        } else return false;
    }
}
