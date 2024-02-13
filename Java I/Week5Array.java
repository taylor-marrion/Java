/* Filename: Week5Array.java
 * Author: Taylor Marrion
 * Date: September 19, 2019
 * Purpose: 
 */
 
 // Import statements
 import java.util.Scanner;

/**
* 
*/
public class Week5Array {
	
 public static void main(String[] args) {
	 
	 // Display a Welcome note
	 System.out.println("Hello! Let's work with arrays!");
	 
	 // Use the Scanner class to input data
	 Scanner in = new Scanner(System.in);
	 
	 // Start code
	 
	 // prompt user for an int
	 System.out.print("Enter a positive integer to count to: ");
	 int num = in.nextInt(); // declare and initialize int to be length of array
	 
	 // declare array
	 int[] arr = new int[num];
	 
	 // use for loop to count
	 for (int i = 0; i < arr.length; i++) {
		 arr[i] = i+1; // start count at 1, not 0
		 System.out.println("arr[" + i + "]=" + arr[i]);
	 }
	 
	 System.out.println("The length of your array is: " + arr.length);
	 
	 // Display a departing note
	 System.out.println("Goodbye!");
	
 } // end method main
 
} // end class