/* Filename: LoopDiscussion.java
 * Author: Taylor Marrion
 * Date: September 5, 2019
 * Purpose: Practice with loops
 */
 
 // Import statements
 import java.util.Scanner;

/**
* This class will ask the user for a positive integer. The class will then count to that number and print square roots as it counts. The class will ask the user to run again or exit.
*/
public class LoopDiscussion {
	
 public static void main(String[] args) {
	 
	 // Display a Welcome note
	 System.out.println("Let's get loopy!");
	 
	 // Variables to hold values
	 boolean againBoolean = true; // when true, program will ask for a number
	 int countTo = -1; // while loop will count up to this number
	 String againString = ""; // stores user input to count again or exit
	 
	 // Use the Scanner class to input data
	 Scanner in = new Scanner(System.in);
	 
	 // start code
	 while (againBoolean) {
		 
		 // only accept positive integers from user input
		 do {
			 System.out.print("Enter a POSITIVE integer to count to and print square roots:");
			 countTo = in.nextInt();
		 } while (countTo < 0);
		 
		 // count to countTo and display square roots
		 for (int i = 1; i <= countTo; i++) {
			 System.out.println("The square root of " + i + " is " + Math.sqrt(i));
		 } // end for loop
		 
		 // ask user to run again
		 System.out.print("Press \"y\" to enter another number(any other key to exit):");
		 againString = in.next();
		 
		 // check user input
		 if (againString.equals("y") || againString.equals("Y")) {
			 System.out.println("Let's try another number!");
		 } else {
			 againBoolean = false; // exit while loop
		 } // end if-else block
		 
	 } // end while loop
	 
	 System.out.println("Goodbye!"); // Display a departing note
	 
 } // end method main
 
} // end class