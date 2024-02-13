/* Filename: MatrixMult.java
 * Author: Taylor Marrion
 * Date: March 1, 2022
 * Purpose: 
 */
 
 // Import statements
 import java.util.*;

/**
* 
*/
public class MatrixMult {
	
	static int[][] adjToMatrix(HashMap<Integer, int[]> adj) {
		int n = adj.size();
		int[][] result = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			int[] row = adj.get(i);
			for (int j = 0; j < row.length; j++) {
				int node = row[j];
				result[i][node] = 1;
			}
		}
		
		return result;
	} // end adjToMatrix
	
	static int[][] copy2dArray(int arr[][]) {
		int[][] copy = new int[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			int[] aMatrix = arr[i];
			int	aLength = aMatrix.length;
			copy[i] = new int[aLength];
			System.arraycopy(aMatrix, 0, copy[i], 0, aLength);
		}
		return copy;
	} // end copy2dArray
	
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
	
	static int[][] getIdentityMatrix(int n) {
		int[][] result = new int[n][n];
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++){
				if (i == j) {
					result[i][j] = 1;
				}
			}
		}
		return result;
	} // end getIdentityMatrix
	
	/* static int[][] power_matrix(int[][] arr, int r){
		int n = arr.length;
		int[][] result = new int[n][n];
		
		int[][] identity_matrix = getIdentityMatrix(n);
		
		while (r > 0) {
			if (r % 2 == 1) {
				identity_matrix = multMatrix(identity_matrix, result);
			}
			arr = multMatrix(arr, arr);
			r = r/2;
		}
		
		return result;
	} // end power_matrix */
	
	static int[][] power_matrix(int[][] arr, int r){
		int n = arr.length;
		int[][] result = getIdentityMatrix(n);
		int[][] base = copy2dArray(arr);
		
		while (r > 0) {
			if (r % 2 == 1) {
				result = multMatrix(result, base);
			}
			base = multMatrix(base, base);
			r = r/2;
		}
		return result;
	} // end power_matrix
	
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
	 //System.out.println("Hi!");
	 
	 // Start code
	 /* // manual testing
	 int[][] arr = {
		 {0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,1},
		 {0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0},
		 {0,1,0,0,0,1,1,0,0,1,0,0,0,0,1,0},
		 {0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,1},
		 {0,0,0,0,0,0,0,0,1,0,1,1,0,0,0,0},
		 {0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
		 {0,0,1,1,0,0,0,0,0,0,0,1,0,0,0,0},
		 {0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0},
		 {1,1,0,0,1,1,0,0,0,0,0,1,1,1,0,1},
		 {1,0,1,1,0,0,0,0,0,0,0,1,0,0,0,1},
		 {0,0,0,1,1,0,0,1,0,0,0,0,0,0,0,1},
		 {0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,1},
		 {0,0,0,0,0,0,0,1,1,0,0,0,0,1,0,0},
		 {0,1,0,0,0,0,0,0,1,0,0,0,1,0,0,0},
		 {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
		 {1,0,0,1,0,0,0,0,1,1,1,1,0,0,0,0}
	 }; */
	 
	 HashMap<Integer, int[]> adj = new HashMap<Integer, int[]>();

	 adj.put(0, new int[] {8, 9, 15});
	 adj.put(1, new int[] {2, 8, 13});
	 adj.put(2, new int[] {1, 5, 6, 9, 14});
	 adj.put(3, new int[] {6, 9, 10, 15});
	 adj.put(4, new int[] {8, 10, 11});
	 adj.put(5, new int[] {2, 8});
	 adj.put(6, new int[] {2, 3, 11});
	 adj.put(7, new int[] {10, 12});
	 adj.put(8, new int[] {0, 1, 4, 5, 11, 12, 13, 15});
	 adj.put(9, new int[] {0, 2, 3, 11, 15});
	 adj.put(10, new int[] {3, 4, 7, 15});
	 adj.put(11, new int[] {4, 6, 8, 9, 15});
	 adj.put(12, new int[] {7, 8, 13});
	 adj.put(13, new int[] {1, 8, 12});
	 adj.put(14, new int[] {2});
	 adj.put(15, new int[] {0, 3, 8, 9, 10, 11});
	 
	 int[][] arr = adjToMatrix(adj);
	 System.out.println("Here's your array:");
	 printArray(arr);
	 int[][] squared = multMatrix(arr, arr);
	 System.out.println("Here's your array squared:");
	 printArray(squared);
	 int[][] cubed = multMatrix(squared, arr);
	 System.out.println("Here's your array cubed:");
	 printArray(cubed);
	 int[][] fourth = multMatrix(squared, squared);
	 System.out.println("Here's your array ^fourth:");
	 printArray(fourth);
	 
	 int[][] test = power_matrix(arr, 4);
	 System.out.println("Here's your array ^fourth:");
	 printArray(test);
	 
	 // Display a Goodbye note
	 System.out.println("Goodbye!");

 } // end method main
 
} // end class