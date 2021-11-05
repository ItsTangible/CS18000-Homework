package ExamMidterm2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Holiday Wishlist Class
 *
 * Reads an input file wishlist and outputs a reformatted file
 *
 * @author Ben Winther
 *
 * @version 11/2/2021
 *
 */
public class HolidayWishlist {

    private static String fileReadQuestion = "What is the name of the file you want to read from?";
    private static String fileProcessedMessage = "The given filename was processed!";
    private static String fileOutputQuestion = "What is the file that you want to output data to?";
    private static String fileOverriddenMessage = "Overwriting the file since it already exists!";
    private static String fileNewWriteMessage = "Writing to a new file since it doesn't already exist!";
    private static String fileWriteSuccessMessage = "Writing to the file was successful!";

    private static String errorNoFile = "The given filename does not exist!";
    private static String errorReadingMessage = "The given filename was not in the right format!";
    private static String errorWritingMessage = "There was an error when writing to the file!";
    private static String errorUndocumentedMessage = "There was an undocumented error when reading from the file!";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println(fileReadQuestion);
        String inputFileName = scan.nextLine();
        String[] wishList = new String[0];

        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            System.out.println(errorNoFile);
        } else if (inputFileName.substring(inputFileName.length()-4, inputFileName.length()).equals(".txt")) {
            System.out.println(errorReadingMessage);
        } else if (!inputFile.canRead()) {
            System.out.println(errorUndocumentedMessage);
        } else {
            try {
                wishList = readFiles(inputFileName);
                System.out.println(fileProcessedMessage);
            } catch (Exception e) {
                System.out.println(errorUndocumentedMessage);
            }
        }

        System.out.println(fileOutputQuestion);
        String outputfileName = scan.nextLine();

        File outputFile = new File(outputfileName);
        if (outputFile.exists()) {
            System.out.println(fileOverriddenMessage);
            try {
                writeFile(wishList, outputfileName);
                System.out.println(fileWriteSuccessMessage);
            } catch (Exception e) {
                System.out.println(errorWritingMessage);
            }

        } else {
            System.out.println(fileNewWriteMessage);
            try {
                writeFile(wishList, outputfileName);
                System.out.println(fileWriteSuccessMessage);
            } catch (Exception e) {
                System.out.println(errorWritingMessage);
            }
        }

    }
    public static String[] readFiles(String filename) throws Exception {
        ArrayList<String> tempList = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String entireList = br.readLine();
        br.close();
        while (entireList.indexOf(',') > 0) {
            tempList.add(entireList.substring(0,entireList.indexOf(',')));
            entireList = entireList.substring(entireList.indexOf(',') + 1, entireList.length());
        }
        int lenOfList = tempList.size();
        String[] finalString = new String[lenOfList];
        for (int i = 0; i < lenOfList; i++) {
            finalString[i] = tempList.get(i);
        }
        return finalString;
    }

    public static void writeFile(String[] giftList, String filename) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        bw.write(giftList[0] + " wants the following things for the holidays: ");
        for (int i = 1; i < giftList.length; i++) {
            if (i == giftList.length - 1) bw.write("and ");
            bw.write(giftList[i]);
            if (i <= giftList.length - 1) bw.write(", ");
        }
    }
}
