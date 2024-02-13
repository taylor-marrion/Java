/*
* File: My3DDemo.java
* Author: Dr. Robertson
* Date: January 1, 2015
* Purpose: This program demonstrates how to create
* and populate 3D arrays in Java
*/


public class My3DDemo {  
// Define constant array size
static final int NUMYEARS = 5;
static final int NUMMONTHS = 20;
static final int NUMDAYS = 10;

   
     // Main method
    public static void main(String args[]){
      System.out.println("Welcome to the MultiDimensional Array Demo");

     
     // Create array of int 3D
      int[][][] precip3D = new int[NUMYEARS][NUMMONTHS][NUMDAYS];
	// Assign random values 
       for (int k=0; k<NUMYEARS; k++) {
         for (int i=0; i<NUMMONTHS; i++) {
            for (int j=0; j<NUMDAYS; j++) {
	      precip3D[k][i][j] = (int) (Math.random() * 30)+1;    
            }
         }     
       }

     // Print results with Year upfront
     // Define BaseYear
	int baseYear = 2010;
	for (int k=0; k<NUMYEARS; k++) {
	   System.out.println("Year is " + (baseYear+k)); 
  
            for (int i=0; i<NUMMONTHS; i++) {  
		 for (int j=0; j<NUMDAYS; j++) {                       
	      System.out.print(precip3D[k][i][j] + "\t");    
            }
              System.out.println(""); 
          }                        
        }

	

    }
   
    
   
}