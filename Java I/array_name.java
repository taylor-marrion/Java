/*
* File: array_name
* Name: Kelvin Weeks
* Date: September 19, 2019
* Purpose: Demonstrate array functionality by printing name
*/

// Imports required utility
import java.util.Arrays;

   public class array_name {


	public static void main(String[] args) {

		// String Contents
		 String name = "Kelvin Weeks";
		// Creates array of characters
		 char NameArray [] = new char[name.length()];
		// Variable for obtaining length of array
		 int arrayLenth = NameArray.length;
		// Variable to use for loop
		 int i;

		// Obtains characters in string and array
		 name.getChars(0, name.length(), NameArray, 0);
		
		// for loop
		    for(i = 0; i <name.length(); i++) {
			// Print results
			 System.out.println(NameArray[i]);
}
			 System.out.print("The length of the array is: " + NameArray.length);

	}
}