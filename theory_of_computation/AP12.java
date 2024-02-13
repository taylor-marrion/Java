/* Filename: AP12.java
 * Author: Taylor Marrion
 * Date: March 1, 2022
 * Purpose: 
 */
 
 // Import statements
 import java.util.*;

/**
* 
*/
public class AP12 {
	
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
	
	/* TESTING PURPOSES ONLY */
	public static void printArrayList(ArrayList<int[]> arr){
		for (int i = 0; i < arr.size(); i++){
			int[] temp = arr.get(i);
			for (int j = 0; j < temp.length; j++){
				System.out.print(temp[j]);
			}
			System.out.print(", ");
		}
	} // end printArrayList
	
	// find edges from an adjacency matrix
	public static ArrayList<int[]> getEdges(int[][] arr) {
		ArrayList<int[]> result = new ArrayList<int[]>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (arr[i][j] == 1) {
					result.add(new int[] {i, j});
				}
			}
		}
		
		return result;
	} // end getEdges
	
	public static void simple_algorithm_karger() {
		
		
		
	} // end simple_algorithm_karger
	
 public static void main(String[] args) {
	 
	 // Display a Welcome note
	 System.out.println("Hi!");
	 
	 // Start code
	 
	 // example
	 HashMap<Integer, int[]> adj = new HashMap<Integer, int[]>();
	 adj.put(0, new int[] {1,2,3});
	 adj.put(1, new int[] {0,2,3,4});
	 adj.put(2, new int[] {0,1,3});
	 adj.put(3, new int[] {0,1,2,4});
	 adj.put(4, new int[] {1,3});
	 
	 int[][] arr = adjToMatrix(adj);
	 System.out.println("Here's your adjacency matrix:");
	 printArray(arr);
	 
	 System.out.println("Here's your edges:");
	 ArrayList<int[]> edges = getEdges(arr);
	 printArrayList(edges);
	 
	 // Display a Goodbye note
	 System.out.println("\nGoodbye!");

 } // end method main
 
} // end class