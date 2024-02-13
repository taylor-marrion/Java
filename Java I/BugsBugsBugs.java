import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *
 * This program the user should input their name and age, and it will output their name.
 * INPUT: Username: John, Age: 21
 * OUTPUT: Hello John, your age is 21.
 *
 * Name: David Charles Mydlarz
 * Filename: BugsBugsBugs.java
 * Class: CMIS141
 * Teacher: Dr. Alla Webb
 * Date: 08.31.2019
 *
 */

public class BugsBugsBugs {

    static String userName;
    static int userAge;

    public static void main(String[] args) throws Exception {

        try {
            Scanner myScanner = new Scanner(System.in);

            System.out.print("Enter your Username (John): ");
            userName = myScanner.next();

            System.out.print("Enter your Age (0-120): ");
            userAge = myScanner.nextInt();

            myScanner.close(); // close the scanner so we don't cause a memory leak.

            if (userAge > 120 || userAge < 0) {
                throw new Error("The age limit is between 0 - 120.");
            }

            System.out.println("");
            System.out.printf("Hello %s, your age is %d.", userName, userAge);

        } catch (Exception err) {
            System.out.println("Exception thrown:\n" + err);
        }
    }

}