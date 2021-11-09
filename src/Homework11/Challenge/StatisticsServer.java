package Homework11.Challenge;

import java.io.*;
import java.net.*;
/**
 * Statistics Server
 * A server that recieves input with the port number: 6429
 *
 * @author Benjamin W.
 *
 * @version 11/8/21
 */
public class StatisticsServer {

    private static final char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static int[] charFrequency = new int[26];
    private static int[] digitFrequency = new int[10];

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(6429);

        Socket socket = serverSocket.accept();

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());

        do {
            int charNum = 0;
            int letterNum = 0;
            int digitNum = 0;
            int puncNum = 0;
            int spaceNum = 0;
            int wordNum = 0;

            String message = reader.readLine();

            // Statistic Calculations Below
            for (int i = 0; i < message.length(); i++) {

                char curr = message.charAt(i);

                charNum++;

                if (Character.isDigit(curr)) {
                    digitNum++;
                    for (int j = 0; j < 10; j++) {
                        if (curr == digitFrequency[j]) {
                            charFrequency[j]++;
                        }
                    }
                } else {
                    int prevCharNum = charNum;
                    for (int j = 0; j < 26; j++) {
                        if (curr == alphabet[j]) {
                            charFrequency[j]++;
                            letterNum++;
                        }
                    }
                    if (prevCharNum == charNum) {
                        if (curr != ' ') puncNum++;
                        else {
                            spaceNum++;
                            charNum--;
                            if (i - puncNum - spaceNum == letterNum + digitNum) {
                                wordNum++;
                            }
                        }
                    }

                }
            }

            String letterFrequency = "";
            for (int i = 0; i < 26; i++) {
                if (charFrequency[i] > 0) {
                    letterFrequency += alphabet[i] + "-" + charFrequency[i] + "\n";
                }
            }
            String digFrequency = "";
            for (int i = 0; i < 10; i++) {
                if (digitFrequency[i] > 0) {
                    digFrequency += digits[i] + "-" + digitFrequency[i] + "\n";
                }
            }
            String response = "The Statistics of " + message + " are:\n"
                    + "Length: " + message.length() + "\n"
                    + "Words: " + wordNum + "\n"
                    + "Punctuation: " + puncNum + "\n"
                    + "Characters: " + charNum + "\n"
                    + "Frequency of Digits:\n" + digFrequency
                    + "Frequency of Letters:\n" + letterFrequency;
            // Statistic Calculations Above

            writer.write(response);
            writer.println();
            writer.flush();
        } while (socket.isConnected());

        writer.close();
        reader.close();

    }

}
