
/* Filename: TestEmployee.java
 * Author: Taylor Marrion
 * Date: 11/3/2019
 * Purpose: This class tests Employee and subclasses.
 * The program will read employee data from a text file of 2014 and 2015 employee data.
 * Once all data is read, a report for each year will be displayed to console. The report will include original data, annual salary of each employee, and average salary of all employees.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestEmployee {

    // declare fields
    private static Employee[] arr2014 = new Employee[10]; // store employee data for 2014
    private static int index2014 = 0; // record which elements of arr2014 have been filled
    private static Employee[] arr2015 = new Employee[10]; // store employee data for 2015
    private static int index2015 = 0; // record which elements of arr2015 have been filled

    public static void readFile(String filename) throws FileNotFoundException {

        Scanner input = new Scanner(new File(filename));

        while (input.hasNextLine()) {
            String str = input.nextLine(); // read next line from file
            String[] elements = str.split(" "); // splits string into array of strings
            addToArray(elements); // adds Employee into Employee array
        } // end while loop
        input.close();
    } // end readFile method

    public static void addToArray(String[] arr) {
		
        int year = Integer.parseInt(arr[0]);
		//System.out.println("title " + arr[1]);
        String title = arr[1]; // Employee, Salesman, or Executive
        String name = arr[2];
        int monthlySalary = Integer.parseInt(arr[3]); // converts string to int

        Employee temp;

        // determine employee type
        if (title.equals("Salesman")) {
            int annualSales = Integer.parseInt(arr[4]);
            temp = new Salesman(name, monthlySalary, annualSales);
        } else if (title.equals("Executive")) {
            int stockPrice = Integer.parseInt(arr[4]);
            temp = new Executive(name, monthlySalary, stockPrice);
        } else {
            temp = new Employee(name, monthlySalary);
        } // end if-else loop

        // determine year
        if (year == 2014) {
            arr2014[index2014] = temp;
            index2014++;
        } else {
            arr2015[index2015] = temp;
            index2015++;
        } // end if-else loop

    } // end addToArray method

    public static void printReport(int year, Employee[] arr, int elements) {
        int averageSalary = 0;

        System.out.println("Annual report for " + year + ":");

        for (int i = 0; i < elements; i++) {
            System.out.print(arr[i].toString());
			System.out.println(" Annual Salary: " + arr[i].annualSalary());
            averageSalary += arr[i].annualSalary();
        } // end for loop
        averageSalary = (averageSalary / elements);
        System.out.println("The average annual salary for " + year + " is: "
                + averageSalary);

    } // end printReport method

    public static void main(String[] args) throws FileNotFoundException {

        Scanner keyboard = new Scanner(System.in); // captures user input from keyboard
        System.out.print(
                "Hello! Please enter your file of employee data(including extension): ");
        String filename = keyboard.next();
        keyboard.close();

        readFile(filename);

        printReport(2014, arr2014, index2014);
        printReport(2015, arr2015, index2015);

        System.out.println("Goodbye!");

    } // end method main

} // end class