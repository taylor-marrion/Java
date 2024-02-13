/* Filename: Homework1.java
 * Author: Taylor Marrion
 * Date: August 30, 2019
 * Purpose: This program will ask the user for input and provide conversions and calculations.
 */
 
 // Import statements
 import java.util.Scanner;

/**
* This class will ask the user for student EMPLID, percentage scores for 3 quizzes, their age in months, and the current temperature in degrees Celsius. The class will then display the data entered with conversions and calculations.
*/
public class Homework1 {
	
 public static void main(String[] args) {
	 
	 // Display a Welcome note
	 System.out.println("Hello!");
	 
	 // Variables to hold values
	 int id_number = 0; // student EMPLID
	 double quiz1 = 0.0; // quiz 1 percentage score
	 double quiz2 = 0.0; // quiz 2 percentage score
	 double quiz3 = 0.0; // quiz 3 percentage score
	 int age_months = 0; // age in months
	 double temp_celsius = 0; // current temperature in degrees Celsius
	 
	 // Use the Scanner class to input data
	 Scanner in = new Scanner(System.in);
	 
	 // Capture Student EMPLID
	 System.out.print("Enter your Student EMPLID (0-999999):");
	 id_number = in.nextInt();
	 
	 // Capture quiz 1 score
	 System.out.print("Enter your quiz 1 percentage score (0.0-100.0):");
	 quiz1 = in.nextDouble();
	 
	 // Capture quiz 2 score
	 System.out.print("Enter your quiz 2 percentage score (0.0-100.0):");
	 quiz2 = in.nextDouble();
	 
	 // Capture quiz 3 score
	 System.out.print("Enter your quiz 3 percentage score (0.0-100.0):");
	 quiz3 = in.nextDouble();
	 
	 // Capture age in months
	 System.out.print("Enter your age in months (0-1440):");
	 age_months = in.nextInt();
	 
	 // Capture current temperature in degrees Celsius
	 System.out.print("Enter the current Temperature in degrees Celsius:");
	 temp_celsius = in.nextDouble();
	 
	 System.out.println(); // empty line for spacing and readbility
	 
	 // Print output
	 System.out.println("***Thank you***");
	 System.out.println("Student EMPLID: " + id_number);
	 System.out.println("Quiz 1 Score: " + quiz1);
	 System.out.println("Quiz 2 Score: " + quiz2);
	 System.out.println("Quiz 3 Score: " + quiz3);
	 System.out.println("Average quiz score: " + ((quiz1+quiz2+quiz3)/3)); // sum of quiz grades divided by number of quiz grades
	 System.out.println("Age in months: " + age_months);
	 System.out.println("Age in years: " + (age_months/12));
	 System.out.println("Temperature in Celsius: " + temp_celsius + "\u00B0"); // unicode degree symbol
	 System.out.println("Temperature in Fahrenheit: " + (((temp_celsius)*(9.0/5.0))+32) + "\u00B0"); // convert Celsius to Fahrenheit
	 
	
 } // end method main
 
} // end class