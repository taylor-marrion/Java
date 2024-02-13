/* For Pell numbers, given by the following recurrence relation:
 *         {0              if n = 0;
 * Pn  =   {1              if n = 1;
 *         {2Pn-1 + Pn-2   otherwise.
 */

import java.util.Scanner;

public class PellGenerator {
    private int calculateRecursively(int n){
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return 2 * (calculateRecursively(n - 1)) + calculateRecursively(n - 2);
        }
    }

    private int calculateIteratively(int n) {
        int pell = 1;
        int previous = 0;
        int temp;

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        for (int i = 2; i <= n; i++) {
            temp = (2 * (pell) + previous);
            previous = pell;
            pell = temp;
        }
        return pell;
    }

    public static void main(String[] args) {
        PellGenerator p = new PellGenerator();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the nth term to be generated: ");
        int input = Integer.parseInt(in.nextLine());
        System.out.println("For n = " + input + ", the Pell number is: \n\t\t" +
                p.calculateRecursively(input) + " (Recursive)");
        System.out.println("\t\t" + p.calculateIteratively(input) + " (Iterative)");
    }
}