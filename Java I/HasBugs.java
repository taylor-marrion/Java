/* File: HasBugs.java
 * Author: Taylor Marrion
 * Date: August 29, 2019
 * Purpose: This program purposefully has bugs left in so that other students can identofy them.
 */
 
 // Import java classes
 import java.io.IOException;
 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 import java.util.Scanner;

/**
* This class will ask a user to rate his/her experience
*/
public class HasBugs {
	
 public static void main(String[] args) {
	 
	 // Use the Scanner class to input data
	 Scanner in = new Scanner(System.in);
	 
	 //ask user to rate experience
	 System.out.print("Please rate your experience with our service from 1-10 (or any other number to skip):");
	 response = in.nextInt();
	 System.out.println("You entered: " + response);
	 
	 // check user response 
	if (response < 1 || response > 10) {
		System.out.println("Goodbye!");
	} else {
		switch (response) {
			case 1:
				System.out.println("Oh no! We have a lot of work to do!");
				break;
			case 2:
				System.out.println("Horrible! We have a lot of work to do!");
				break;
			case 3:
				System.out.println("Bad! We have a lot of work to do!");
				break;
			case 4:
				System.out.println("Needs work! We have a lot of work to do!");
				break;
			case 5:
				System.out.println("Sub-par! We strive to improve.");
				break;
			case 6:
				System.out.println("Mediocre! We strive to improve.");
				break;
			case 7:
				System.out.println("Good! Glad we could help!");
				break;
			case 8:
				System.out.println("Great! There's always room to improve.");
				break;
			case 9:
				System.out.println("Amazing! There's always room to improve.");
				break;
			case 10:
				System.out.println("Perfect! We will strive to maintain this level of service.");
				break;
				
		} // end switch
		
		System.out.println("Thanks for your feedback!");
	
	System.exit(0);
	
 } // end method main
 
} // end class HasBugs