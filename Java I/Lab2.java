/* File: 
 * Author: Taylor Marrion
 * Date: dd-mm-yyyy
 * Purpose: 
 */
 
 // Import java classes
 import java.io.IOException;
 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 import java.util.Scanner;

/**
* Working through lab 2
*/
public class Lab2 {
	
 public static void main(String[] args) {
	 
	 Scanner scannerIn = new Scanner(System.in);
	 System.out.print("Enter an integer: ");
	 int tryScan = scannerIn.nextInt(); // example
	 System.out.println("You entered " + tryScan);
	 
	 // Switch demo
	 int month = 0;
	 int days = 0;
	 System.out.print("Enter the month (1-12):");
	 month = scannerIn.nextInt();
	 System.out.println("You entered: " + month);
	 
	 switch (month) {
		 case 1:
			System.out.println("January");
			break;
		case 2:
			System.out.println("Febuary");
			break;
		case 3:
			System.out.println("March");
			break;
		case 4:
			System.out.println("April");
			break;
		case 5:
			System.out.println("May");
			break;
		case 6:
			System.out.println("June");
			break;
		case 7:
			System.out.println("July");
			break;
		case 8:
			System.out.println("August");
			break;
		case 9:
			System.out.println("September");
			break;
		case 10:
			System.out.println("October");
			break;
		case 11:
			System.out.println("November");
			break;
		case 12:
			System.out.println("December");
			break;
	 } // end switch

 } // end method main
 
} // end class Lab2