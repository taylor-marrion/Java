/* Filename: USCrimeClass.java
 * Author: Taylor Marrion
 * Date: 10/12/2019
 * Purpose: This class will create instances of USCrimeClass objects and provide related methods.
 */
 
 // Import statements
 import java.io.*;
 import java.util.*;

public class USCrimeClass {
	
	// declare fields
	private int year;
	private int population;
	private int violentCrimeCount;
	private double violentCrimeRate;
	private int murderCount;
	private double murderRate;
	private int rapeCount;
	private double rapeRate;
	private int robberyCount;
	private double robberyRate;
	private int assaultCount;
	private double assaultRate;
	private int propertyCrimeCount;
	private double propertyCrimeRate;
	private int burglaryCount;
	private double burglaryRate;
	private int larcenyCount;
	private double larcenyRate;
	private int vehicleTheftCount;
	private double vehicleTheftRate;
	
	// constructor from array of strings
	public USCrimeClass(String[] array){
		this.year = Integer.parseInt(array[0]);
		this.population = Integer.parseInt(array[1]);
		this.violentCrimeCount = Integer.parseInt(array[2]);
		this.violentCrimeRate = Double.parseDouble(array[3]);
		this.murderCount = Integer.parseInt(array[4]);
		this.murderRate = Double.parseDouble(array[5]);
		this.rapeCount = Integer.parseInt(array[6]);
		this.rapeRate = Double.parseDouble(array[7]);
		this.robberyCount = Integer.parseInt(array[8]);
		this.robberyRate = Double.parseDouble(array[9]);
		this.assaultCount = Integer.parseInt(array[10]);
		this.assaultRate = Double.parseDouble(array[11]);
		this.propertyCrimeCount = Integer.parseInt(array[12]);
		this.propertyCrimeRate = Double.parseDouble(array[13]);
		this.burglaryCount = Integer.parseInt(array[14]);
		this.burglaryRate = Double.parseDouble(array[15]);
		this.larcenyCount = Integer.parseInt(array[16]);
		this.larcenyRate = Double.parseDouble(array[17]);
		this.vehicleTheftCount = Integer.parseInt(array[18]);
		this.vehicleTheftRate = Double.parseDouble(array[19]);
		
	} // end constructor
	
	// getter methods
	public int getYear() {
		return this.year;
	}
	public int getPopulation() {
		return this.population;
	}
	public int getViolentCrimeCount() {
		return this.violentCrimeCount;
	}
	public double getViolentCrimeRate(){
		return this.violentCrimeRate;
	}
	public int getMurderCount() {
		return this.murderCount;
	}
	public double getMurderRate(){
		return this.murderRate;
	}
	public int getRapeCount() {
		return this.rapeCount;
	}
	public double getRapeRate() {
		return this.rapeRate;
	}
	public int getRobberyCount() {
		return this.rapeCount;
	}
	public double getRobberyRate() {
		return this.robberyRate;
	}
	public int getAssaultCount() {
		return this.assaultCount;
	}
	public double getAssaultRate() {
		return this.assaultRate;
	}
	public int getPropertyCrimeCount() {
		return this.propertyCrimeCount;
	}
	public double getPropertyCrimeRate() {
		return this.propertyCrimeRate;
	}
	public int getBurglaryCount() {
		return this.burglaryCount;
	}
	public double getBurglaryRate() {
		return this.burglaryRate;
	}
	public int getLarcenyCount() {
		return this.larcenyCount;
	}
	public double getLarcenyRate() {
		return this.larcenyRate;
	}
	public int getVehicleTheftCount() {
		return this.vehicleTheftCount;
	}
	public double getVehicleTheftRate() {
		return this.vehicleTheftRate;
	}
	
	/*
	* method to count the number of rows in a csv file
	*/
	public static int getRowCount(String filename) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(filename)); // BufferedReader to read from file
		int rowCount = 0;
		while(reader.readLine() != null){
			rowCount++;
		}
		reader.close();
		return rowCount;
	} // end getRowCount method
	
	/*
	* method to create array of USCrimeClass objects
	*/
	public static USCrimeClass[] getCrimeArray(String filename) throws IOException{
		int numYears = getRowCount(filename) - 1; // total rows minus titles row
		USCrimeClass[] crimeArray = new USCrimeClass[numYears];
		BufferedReader reader = new BufferedReader(new FileReader(filename)); // BufferedReader to read from file
		
		reader.readLine(); // skips first row of titles
		
		for(int i = 0; i<numYears; i++){
			String str = reader.readLine(); // reads line as String
			String[] arr = str.split(","); // splits String into array by commas
			USCrimeClass crime = new USCrimeClass(arr); // creates USCrimeClass from array of Strings
			crimeArray[i] = crime; // stores crime in array
		} // end for loop
		
		return crimeArray;
	} // end getCrimeArray method
	
	/*
	* method to calculate population growth rate in a single year
	*/
	public static double getPopGrowthRate(USCrimeClass[] array, int year){
		double prevYearPop = (array[year-1].getPopulation())*1.0;
		double thisYearPop = (array[year].getPopulation())*1.0;
		double popGrowthRate = ((thisYearPop-prevYearPop)/prevYearPop)*100;
		
		return popGrowthRate;
	} // end getPopGrowthRate
	
	/*
	* method to print population grwoth rates for all years
	*/
	public static void printPopGrowthRates(USCrimeClass[] array){
		for(int i = 1; i<array.length; i++){
			double popGrowthRate = getPopGrowthRate(array,i);
			String fourDigits = String.format("%.4f",popGrowthRate); // format popGrowthRate to display only 4 digits after decimal
			int currentYear = array[i].getYear();
			int lastYear = array[i-1].getYear();
			System.out.println("The population growth from " + lastYear + " to " + currentYear + " was " + fourDigits + "%.");
		}
	} // end printPopGrowthRates
	
	/*
	* method to find the year of the maximum murder rate
	*/
	public static int getMaxMurderRate(USCrimeClass[] array){
		double max = array[0].getMurderRate(); // max murder rate
		double temp = array[0].getMurderRate(); // holding value for murder rates
		int year = array[0].getYear();
		
		for(int i = 0; i < array.length; i++){
			temp = array[i].getMurderRate();
			if (temp > max){
				max = temp;
				year = array[i].getYear();
			}
		} // end for loop
		
		return year;
	} // end getMaxMurderRate method
	
	/*
	* method to find the year of the minimum murder rate
	*/
	public static int getMinMurderRate(USCrimeClass[] array){
		double min = array[0].getMurderRate(); // min murder rate
		double temp = array[0].getMurderRate(); // holding value for murder rates
		int year = array[0].getYear();
		
		for(int i = 0; i < array.length; i++){
			temp = array[i].getMurderRate();
			if (temp < min){
				min = temp;
				year = array[i].getYear();
			}
		} // end for loop
		
		return year;
	} // end getMinMurderRate method
	
	/*
	* method to find the year of the maximum robbery rate
	*/
	public static int getMaxRobberyRate(USCrimeClass[] array){
		double max = array[0].getRobberyRate(); // max robbery rate
		double temp = array[0].getRobberyRate(); // holding value for robbery rates
		int year = array[0].getYear();
		
		for(int i = 0; i < array.length; i++){
			temp = array[i].getRobberyRate();
			if (temp > max){
				max = temp;
				year = array[i].getYear();
			}
		} // end for loop
		
		return year;
	} // end getMaxRobberyRate method
	
	/*
	* method to find the year of the minimum robbery rate
	*/
	public static int getMinRobberyRate(USCrimeClass[] array){
		double min = array[0].getRobberyRate(); // min robbery rate
		double temp = array[0].getRobberyRate(); // holding value for robbery rates
		int year = array[0].getYear();
		
		for(int i = 0; i < array.length; i++){
			temp = array[i].getRobberyRate();
			if (temp < min){
				min = temp;
				year = array[i].getYear();
			}
		} // end for loop
		
		return year;
	} // end getMinRobberyRate method
 
} // end class