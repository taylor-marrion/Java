/* Filename: AP14.java
 * Author: Taylor Marrion
 * Date: March 1, 2022
 * Purpose: 
 */
 
 // Import statements
 import java.util.*;

/**
* 
*/
public class AP14 {
	
	/* Multiply matrices of any size */
	static int[][] multMatrix(int a[][], int b[][]){
		try {
			if (a[0].length != b.length) {
				throw new Exception("Your matrices are not properly sized for multiplication together.");
			}
			
			int aRow = a.length;
			int aColumn = a[0].length;
			int bRow = b.length;
			int bColumn = b[0].length;
			int[][] c = new int[aRow][bColumn];
			
			for (int i = 0; i<aRow; i++) {
				for (int j = 0; j<bColumn; j++) {
					for (int k = 0; k<bRow; k++) {
						c[i][j] = c[i][j] + a[i][k] * b[k][j];
					}
				}
			}
			return c;
		} catch (Exception e) {
			return null;
		}
	} // end multMatrix
	
	/* reduce ints to modulo 2, to reflect bit values */
	static int[][] mod2 (int[][] arr){
		int n = arr.length;
		int m = arr[0].length;
		int[][] result = new int[n][m];
		for (int i = 0; i < n; i++){
			for (int j = 0; j < m; j++){
				arr[i][j] %= 2;
			}
		}
		return result;
	} // end mod2
	
	/* Determine position of syndrome within H^T */ 
	static int findIndexOfSyndrome (int[][]s, int[][]Ht){
		int result = -1;
		
		for (int i = 0; i < Ht.length; i++){
			if (Arrays.equals(s[0], Ht[i])){
				return i;
			}
		}
		
		return result;
	} // end findIndexOfSyndrome
	
	/* OVERLOADED: A utility function to print array of size n */
	static void printArray(int a[]) {
		int n = a.length;
		for (int i=0; i<n; i++) {
			System.out.print(a[i] + " ");
		} // end for-loop
		System.out.println();
	} // end printArray
	
	/* OVERLOADED: A utility function to print array of size n*m */
	static void printArray(int a[][]) {
		for (int i = 0; i < a.length; i++) {
		 int[] row = a[i];
		 
		 String arrString = "[";
		 for (int j = 0; j < row.length; j++) {
			 arrString += String.format("%3d, ", row[j]);
		 }
		 arrString = arrString.substring(0, arrString.length()-2);
		 arrString += "]";
		 
		 String str = String.format("%3d: %s", i, arrString);
		 //String str = String.format("%3s: %s", String.valueOf(i), arrString);
		 System.out.println(str);
	 }
	} // end printArray
	
 public static void main(String[] args) {
	 
	 // Display a Welcome note
	 System.out.println("Hi!");
	 
	 // Start code
	 
	 
	 // Problem 1 - test against solutions found by hand
	 int[][] G1 = {
		 {1,0,0,0,1,1,1},
		 {0,1,0,0,0,1,1},
		 {0,0,1,0,1,0,1},
		 {0,0,0,1,1,1,0}
	 };
	 
	 int[][] Ht1 = {
		 {1,1,1},
		 {0,1,1},
		 {1,0,1},
		 {1,1,0},
		 {1,0,0},
		 {0,1,0},
		 {0,0,1}
	 };
	 
	 System.out.println("\n========= Problem 1 - Part a =========");
	 int[][] x1a = {{1,0,0,1}};
	 int[][] c1a = multMatrix(x1a, G1);
	 mod2(c1a);
	 System.out.println("c = xG =");
	 printArray(c1a);
	 int[][] s1a = multMatrix(c1a, Ht1);
	 mod2(s1a);
	 System.out.println("s = cH^t = ");
	 printArray(s1a);
	 
	 System.out.println("\n========= Problem 1 - Part b =========");
	 int[][] c1b = {{0,1,1,1,1,0,1}};
	 System.out.println("c =");
	 printArray(c1b);
	 int[][] s1b = multMatrix(c1b, Ht1);
	 mod2(s1b);
	 System.out.println("s = cH^t = ");
	 printArray(s1b);
	 int syn1b = findIndexOfSyndrome(s1b, Ht1);
	 System.out.println("Index of Syndrome : " + syn1b);
	 
	 System.out.println("\n========= Problem 1 - Part c =========");
	 int[][] c1c = {{0,0,0,1,1,0,0}};
	 System.out.println("c =");
	 printArray(c1c);
	 int[][] s1c = multMatrix(c1c, Ht1);
	 mod2(s1c);
	 System.out.println("s = cH^t = ");
	 printArray(s1c);
	 
	 
	 // Problem 2
	 int[][] G2 = {
		 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
		 {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
		 {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
		 {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
		 {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1},
		 {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
		 {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1},
		 {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0},
		 {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0},
		 {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0},
		 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0}
	 };
	 
	 int[][] Ht2 = {
		 {1, 1, 1, 1},
		 {0, 1, 1, 1},
		 {1, 0, 1, 1},
		 {0, 0, 1, 1},
		 {1, 1, 0, 1},
		 {0, 1, 0, 1},
		 {1, 0, 0, 1},
		 {1, 1, 1, 0},
		 {0, 1, 1, 0},
		 {1, 0, 1, 0},
		 {1, 1, 0, 0},
		 {1, 0, 0, 0},
		 {0, 1, 0, 0},
		 {0, 0, 1, 0},
		 {0, 0, 0, 1}
	 };
	 
	 System.out.println("\n========= Problem 2 - Part a =========");
	 int[][] x2a = {{1,0,1,0,1,0,1,0,1,0,1}};
	 int[][] c2a = multMatrix(x2a, G2);
	 mod2(c2a);
	 System.out.println("c = xG =");
	 printArray(c2a);
	 int[][] s2a = multMatrix(c2a, Ht2);
	 mod2(s2a);
	 System.out.println("s = cH^t = ");
	 printArray(s2a);
	 
	 System.out.println("\n========= Problem 2 - Part b =========");
	 int[][] c2b = {{1,0,1,0,0,1,1,1,0,0,0,1,0,1,0}};
	 System.out.println("c =");
	 printArray(c2b);
	 int[][] s2b = multMatrix(c2b, Ht2);
	 mod2(s2b);
	 System.out.println("s = cH^t = ");
	 printArray(s2b);
	 
	 // Display a Goodbye note
	 System.out.println("\nGoodbye!");

 } // end method main
 
} // end class