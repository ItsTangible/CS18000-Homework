package Homework02;

/**
 * Protect Purdue
 *
 * Prints out the fist part of the "Protect Purdue" Pledge
 * focusing on protecting yourself.
 *
 * @author Benjamin Winther, lab sec L14
 *
 * @version August 30, 2021
 */
public class ProtectPurdue {

    // The first Protect Purdue statement
    final static String STATEMENT_1 = "1. Get vaccinated"
            + " against COVID-19 and submit valid proof OR"
            + " successfully fulfill my routine surveillance"
            + " testing responsibilities.";

    // The second Protect Purdue statement
    final static String STATEMENT_2 = "2. If I experience any"
            + " symptoms of COVID-19, whether I am vaccinated or"
            + " not,";

    // second half of second Protect Purdue statement
    final static String STATEMENT_2_1 = "I will contact the"
            + " Protect Purdue Health Center (PPHC) right away,"
            + " quarantine in the meantime and follow additional"
            + " instructions.";

    // The third Protect Purdue statement
    final static String STATEMENT_3 = "3. Take personal"
            + " responsibility, access available resources and"
            + " practice self-care for my mental health and"
            + " overall well-being";

    public static void main(String[] args) {
        System.out.println("I pledge to:");
        gap();
        System.out.println(STATEMENT_1);
        gap();
        System.out.println(STATEMENT_2);
        System.out.println(STATEMENT_2_1);
        gap();
        System.out.println(STATEMENT_3);
    }

    // Prints a blank line to leave a gap between lines
    public static void gap() {
        System.out.println();
    }

}
