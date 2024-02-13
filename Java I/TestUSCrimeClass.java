/* Filename: TestUSCrimeClass.java
 * Author: Taylor Marrion
 * Date: 10/12/2019
 * Purpose: This program tests the USCrimeClass class. This program uses a command line argument to generate an array of USCrimeClass objects from a .csv file, then calculates trends in population growth and criminal activity statistics. Users will be greeted with a menu of questions that can be answered. Upon quitting, the runtime will be displayed in seconds.
 */
 
 // Import statements
 import java.io.*;
 import java.util.*;
 import java.time.*;
 import static java.time.temporal.ChronoUnit.SECONDS;

/**
* 
*/
public class TestUSCrimeClass {
	
 public static void main(String[] args) throws FileNotFoundException, IOException {
	 
	 LocalDateTime startTime = LocalDateTime.now(); // start time
	 
	 Scanner keyboard = new Scanner(System.in); // Use the Scanner class to input data
	 
	 // Display a Welcome note
	 System.out.println("********** Welcome to the US Crime Statistical Application **********");
	 
	 String filename = args[0]; // collect filename from command line
	 
	 USCrimeClass[] crimeArray = USCrimeClass.getCrimeArray(filename); // create array of USCrimeClass objects
	 
	 int maxMurderRate = USCrimeClass.getMaxMurderRate(crimeArray); // find year with maximum murder rate
	 
	 int minMurderRate = USCrimeClass.getMinMurderRate(crimeArray); // find year with minimum murder rate
	 
	 int maxRobberyRate = USCrimeClass.getMaxRobberyRate(crimeArray); // find year with maximum robbery rate
	 
	 int minRobberyRate = USCrimeClass.getMinRobberyRate(crimeArray); // find year with minimum robbery rate
	 

	 String again = "";
	 do {
		 System.out.println();
		 System.out.println("Enter the number of the question you want answered. Enter \"Q\" to quit the program:");
		 System.out.println();
		 System.out.println("1. What were the percentages in population growth for each consecutive year from 1994 - 2013?");
		 System.out.println("2. What year was the Murder rate the highest?");
		 System.out.println("3. What year was the Murder rate the lowest?");
		 System.out.println("4. What year was the Robbery rate the highest?");
		 System.out.println("5. What year was the Robbery rate the lowest?");
		 System.out.println("Q. Quit the program");
		 System.out.println();
		 System.out.print("Enter your selection: ");
		 again = keyboard.nextLine();
		 System.out.println();
		 
		 switch(again){
			 case "1":
			 USCrimeClass.printPopGrowthRates(crimeArray);
			 break;
			 case "2":
			 System.out.println("The Murder rate was highest in " + maxMurderRate);
			 break;
			 case "3":
			 System.out.println("The Murder rate was lowest in " + minMurderRate);
			 break;
			 case "4":
			 System.out.println("The Robbery rate was highest in " + maxRobberyRate);
			 break;
			 case "5":
			 System.out.println("The Robbery rate was lowest in " + minRobberyRate);
			 break;
			 case "q":
			 case "Q":
			 System.out.println();
			 break;
			 default:
			 System.out.println("Invalid input! Please look at the menu carefully.");
		 } // end switch case
	 } while (!(again.equalsIgnoreCase("Q")));
	 
	 LocalDateTime stopTime = LocalDateTime.now(); // stop time
	 long diff = SECONDS.between(startTime, stopTime); // calculate difference in time in seconds

	 
	 // Display exit note
	 System.out.println("Thank you for trying the US Crimes Statistics Program.");
	 
	 System.out.println(); // used for spacing
	 
	 System.out.println("Elapsed time in seconds was : " + diff); // display elapsed time
	
 } // end method main
 
} // end class