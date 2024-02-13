/* Filename: TestMultidimensionalArray.java
 * Author: Taylor Marrion
 * Date: August 30, 2019
 * Purpose: 
 */
 
 // Import statements
 import java.util.*;

public class TestMultidimensionalArray {

 public static void main(String[] args) {
	 
	 // Use the Scanner class to input data
	 Scanner in = new Scanner(System.in);
	 
	 int count = 0;
	 
	 // create 2D array
	 int[][] arr = new int[5][10];
	 for (int row = 0; row<arr.length; row++) {
		 for (int col =0; col<arr[row].length; col++) {
			 count++;
			 arr[row][col] = (count);
		 } // end col for loop
	 } // end row for loop
	 
	 // print 2D array
	 System.out.println("2D array");
	 for (int row = 0; row<arr.length; row++) {
		 for (int col =0; col<arr[row].length; col++) {
			 System.out.print(arr[row][col] + " ");
		 } // end col for loop
		 System.out.println(); // move to next row
	 } // end row for loop
	 
	 System.out.println();
	 
	 // create 3D array
	 int iNum = 3;
	 int jNum = 5;
	 int kNum = 10;
	 int[][][] threeDArr = new int[iNum][jNum][kNum];
	 for (int i = 0; i<iNum; i++) {
		 count = 0;
		 for (int j =0; j<jNum; j++) {
			 for (int k=0; k<kNum; k++) {
				 count++;
				 threeDArr[i][j][k] = count;
			 } // end k col for loop
		 } // end j row for loop
	 } // end i plane for loop
	 
	 // print 3D array
	 System.out.println("3D array");
	 for (int i = 0; i<iNum; i++) {
		 System.out.println("Plane " + i);
		 for (int j =0; j<jNum; j++) {
			 for (int k=0; k<kNum; k++) {
			 System.out.print(threeDArr[i][j][k] + " "); // 
			 } // end k col for loop
			 System.out.println(); // move to next row
		 } // end j row for loop
		 System.out.println(); // move to next plane
	 } // end i plane for loop
	 
 } // end method main
 
} // end class