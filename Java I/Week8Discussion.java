/* Filename: Week8Discussion.java
 * Author: Taylor Marrion
 * Date: 10/2/2019
 * Purpose: This program will prompt the user for a file to read from, then read the file line by line. Each item read from the file will be determined to be a double or non-double value, then printed to the console. After reaching the end of the file, the program will display a count of double and non-double values.
 */
 
 // Import statements
 import java.io.*;
 import java.util.*;

public class Week8Discussion {
	
 public static void main(String[] args) throws IOException {
	 
	 // Variables to hold values
	 int line = 0; // counts lines of code from input file
	 int count = 0; // int used to count how many doubles are read from inFile
	 
	 // Scanners and input objects
	 Scanner keyboard = new Scanner(System.in); // Scanner to capture filename from user
	 System.out.print("Please enter the file of doubles you wish to read from, including file extension (ex. \"doubles.txt\"): ");
	 String filename = keyboard.next(); // string value to hold filename entered by user
	 File inFile = new File(filename); // input file to be read from
	 Scanner input = new Scanner(inFile); // scanner to read from inFile
	 
	 while(input.hasNext()){
		 String str = input.next();
		 line++;
		 
		 // check if next line is a double
		 try{
			 double temp = Double.parseDouble(str);
			 System.out.println(temp);
			 count++;
		 } catch (NumberFormatException e){
			 System.out.println("Line " + line + ": \"" + str + "\" is not a double!");
		 } // end try-catch
		 		 
	 } // end while loop
	 
	 System.out.println(); // used for spacing
	 // provide summary of file contents
	 System.out.println(filename + " has " + count + " double(s) and " + (line-count) + " non-double value(s).");
	 
	 input.close(); // close the file being read
	 
 } // end method main
 
} // end class