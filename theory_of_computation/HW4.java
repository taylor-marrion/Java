/* Filename: HW4.java
 * Author: Taylor Marrion
 * Date: March 1, 2022
 * Purpose: 
 */
 
 // Import statements
 import java.util.*;

/**
* 
*/
public class HW4 {
	
	static int[][] HashMapTo2DArray(HashMap<Integer, int[]> adj) {
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
	} // end HashMapTo2DArray
	
	static boolean[][] HashMapTo2DBooleanArray(HashMap<Integer, int[]> adj) {
		int n = adj.size();
		boolean[][] result = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			int[] row = adj.get(i);
			for (int j = 0; j < row.length; j++) {
				int node = row[j];
				result[i][node] = true;
			}
		}
		
		return result;
	} // end HashMapTo2DBooleanArray
	
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
	
	static double[][] copy2dArray(double arr[][]) {
		double[][] copy = new double[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			double[] aMatrix = arr[i];
			int	aLength = aMatrix.length;
			copy[i] = new double[aLength];
			System.arraycopy(aMatrix, 0, copy[i], 0, aLength);
		}
		return copy;
	} // end copy2dArray
	
	static boolean[][] copy2dArray(boolean arr[][]) {
		boolean[][] copy = new boolean[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			boolean[] aMatrix = arr[i];
			int	aLength = aMatrix.length;
			copy[i] = new boolean[aLength];
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
	
	/* Multiply matrices of any size */
	static double[][] multMatrix(double a[][], double b[][]){
		try {
			if (a[0].length != b.length) {
				throw new Exception("Your matrices are not properly sized for multiplication together.");
			}
			
			int aRow = a.length;
			int aColumn = a[0].length;
			int bRow = b.length;
			int bColumn = b[0].length;
			double[][] c = new double[aRow][bColumn];
			
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
	
	/* Multiply matrices of any size */
	static boolean[][] multMatrix(boolean a[][], boolean b[][]){
		try {
			if (a[0].length != b.length) {
				throw new Exception("Your matrices are not properly sized for multiplication together.");
			}
			
			int aRow = a.length;
			int aColumn = a[0].length;
			int bRow = b.length;
			int bColumn = b[0].length;
			boolean[][] c = new boolean[aRow][bColumn];
			
			for (int i = 0; i<aRow; i++) {
				for (int j = 0; j<bColumn; j++) {
					for (int k = 0; k<bRow; k++) {
						c[i][j] = c[i][j] || (a[i][k] && b[k][j]);
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
	
	static double[][] getIdentityMatrix_double(int n) {
		double[][] result = new double[n][n];
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++){
				if (i == j) {
					result[i][j] = 1.0;
				}
			}
		}
		return result;
	} // end getIdentityMatrix
	
	static boolean[][] getIdentityMatrix_boolean(int n) {
		boolean[][] result = new boolean[n][n];
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++){
				if (i == j) {
					result[i][j] = true;
				}
			}
		}
		return result;
	} // end getIdentityMatrix
	
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
	
	static double[][] power_matrix(double[][] arr, int r){
		int n = arr.length;
		double[][] result = getIdentityMatrix_double(n);
		double[][] base = copy2dArray(arr);
		
		while (r > 0) {
			if (r % 2 == 1) {
				result = multMatrix(result, base);
			}
			base = multMatrix(base, base);
			r = r/2;
		}
		return result;
	} // end power_matrix
	
	static boolean[][] power_matrix(boolean[][] arr, int r){
		int n = arr.length;
		boolean[][] result = getIdentityMatrix_boolean(n);
		boolean[][] base = copy2dArray(arr);
		
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
	
	/* OVERLOADED: A utility function to print array of size n*m */
	static void printArray(double a[][]) {
		for (int i = 0; i < a.length; i++) {
		 double[] row = a[i];
		 
		 String arrString = "[";
		 for (int j = 0; j < row.length; j++) {
			 arrString += String.format("%10f, ", row[j]);
		 }
		 arrString = arrString.substring(0, arrString.length()-2);
		 arrString += "]";
		 
		 String str = String.format("%3d: %s", i, arrString);
		 //String str = String.format("%3s: %s", String.valueOf(i), arrString);
		 System.out.println(str);
	 }
	} // end printArray
	
	/* OVERLOADED: A utility function to print array of size n*m */
	static void printArray(boolean a[][]) {
		for (int i = 0; i < a.length; i++) {
		 boolean[] row = a[i];
		 
		 String arrString = "[";
		 for (int j = 0; j < row.length; j++) {
			 String booStr = row[j] ? "1" : "0";
			 arrString += String.format("%s, ", booStr);
			 //arrString += String.format("%5b, ", row[j]);
		 }
		 arrString = arrString.substring(0, arrString.length()-2);
		 arrString += "]";
		 
		 String str = String.format("%3d: %s", i, arrString);
		 //String str = String.format("%3s: %s", String.valueOf(i), arrString);
		 System.out.println(str);
	 }
	} // end printArray
	
	/* OVERLOADED: A utility function to print a transition matrix stored in a LinkedHashMap of size of n*n where n is the number of states */
	static void printLinkedHashMap(LinkedHashMap<String, double[]> map) {
		Set<String> keys = map.keySet();
		Iterator<String> iterator = keys.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			System.out.print(String.format("%10s", str));
			if (!iterator.hasNext()) {
				System.out.print(String.format("\n"));
			}
		}
	 
		iterator = keys.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			double[] row = map.get(str);
			String arrString = "[";
			for (int i = 0; i < row.length; i++) {
				arrString += String.format("%8f, ", row[i]);
			}
			arrString = arrString.substring(0, arrString.length()-2);
			arrString += "]";
			str = String.format("%3s: %s", str, arrString);
			//String str = String.format("%3c: %s", String.valueOf(i), arrString);
			System.out.println(str);
		}
	} // end printLinkedHashMap
	
 public static void main(String[] args) {
	 
	 // Display a Welcome note
	 //System.out.println("Hi!");
	 
	 // Start code
	 /* // Problem 1
	 HashMap<Integer, int[]> adj = new HashMap<Integer, int[]>();
	 adj.put(0, new int[] {7, 9});
	 adj.put(1, new int[] {5, 11});
	 adj.put(2, new int[] {8, 11});
	 adj.put(3, new int[] {8, 10});
	 adj.put(4, new int[] {7, 8, 10, 11});
	 adj.put(5, new int[] {1, 6, 9, 10});
	 adj.put(6, new int[] {5, 8});
	 adj.put(7, new int[] {0, 4, 9});
	 adj.put(8, new int[] {2, 3, 4, 6});
	 adj.put(9, new int[] {0, 5, 7});
	 adj.put(10,new int[] {3, 4, 5});
	 adj.put(11,new int[] {1, 2, 4});
	 
	 int[][] arr = HashMapTo2DArray(adj);
	 System.out.println("Here's your array:");
	 printArray(arr);
	 int[][] squared = power_matrix(arr, 2);
	 System.out.println("Here's your array squared:");
	 printArray(squared);
	 int[][] cubed = power_matrix(arr, 3);
	 System.out.println("Here's your array cubed:");
	 printArray(cubed);
	 int[][] fourth = power_matrix(arr, 4);
	 System.out.println("Here's your array ^fourth:");
	 printArray(fourth); */
	 
	 /* // Problem 2
	 double[][] coinStates = {
		{1.0, 0.0, 0.0, 0.0, 0.0},
		{0.4, 0.0, 0.6, 0.0, 0.0}, // tipped off
		{0.0, 0.5, 0.0, 0.5, 0.0},
		{0.0, 0.0, 0.5, 0.0, 0.5},
		{0.0, 0.0, 0.0, 0.0, 1.0}
	 };
	 
	 LinkedHashMap<String, double[]> coinHash = new LinkedHashMap<String, double[]>();
	 coinHash.put("SL", coinStates[0]);
	 coinHash.put("S1", coinStates[1]);
	 coinHash.put("S2", coinStates[2]);
	 coinHash.put("S3", coinStates[3]);
	 coinHash.put("SW", coinStates[4]);
	 
	 System.out.println("Here's how the coin game starts (P^1):");
	 printLinkedHashMap(coinHash);
	 
	 System.out.println("\nHere's how the game looks after 100 moves (P^100):");
	 double[][] CG_100 = power_matrix(coinStates, 100);
	 coinHash.put("SL", CG_100[0]);
	 coinHash.put("S1", CG_100[1]);
	 coinHash.put("S2", CG_100[2]);
	 coinHash.put("S3", CG_100[3]);
	 coinHash.put("SW", CG_100[4]);
	 printLinkedHashMap(coinHash); */
	 
	 // Problem 3
	 /* double[][] gamblingStates = {
		{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
		{0.6, 0.0, 0.4, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
		{0.0, 0.6, 0.0, 0.4, 0.0, 0.0, 0.0, 0.0, 0.0},
		{0.0, 0.0, 0.6, 0.0, 0.4, 0.0, 0.0, 0.0, 0.0},
		{0.0, 0.0, 0.0, 0.6, 0.0, 0.4, 0.0, 0.0, 0.0},
		{0.0, 0.0, 0.0, 0.0, 0.6, 0.0, 0.4, 0.0, 0.0},
		{0.0, 0.0, 0.0, 0.0, 0.0, 0.6, 0.0, 0.4, 0.0},
		{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.6, 0.0, 0.4},
		{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0}
		// timid strategy
	 }; */
	 
	 /* double[][] gamblingStates = {
		{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
		{0.6, 0.0, 0.4, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
		{0.6, 0.0, 0.0, 0.0, 0.4, 0.0, 0.0, 0.0, 0.0},
		{0.6, 0.0, 0.0, 0.0, 0.0, 0.0, 0.4, 0.0, 0.0},
		{0.6, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.4},
		{0.0, 0.0, 0.6, 0.0, 0.0, 0.0, 0.0, 0.0, 0.4},
		{0.0, 0.0, 0.0, 0.0, 0.6, 0.0, 0.0, 0.0, 0.4},
		{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.6, 0.0, 0.4},
		{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0}
		// bold strategy
	 }; */
	 
	 /* double[][] gamblingStates = {
		{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
		{0.6, 0.0, 0.4, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
		{0.0, 0.6, 0.0, 0.4, 0.0, 0.0, 0.0, 0.0, 0.0},
		{0.0, 0.0, 0.6, 0.0, 0.4, 0.0, 0.0, 0.0, 0.0},
		{0.0, 0.0, 0.6, 0.0, 0.0, 0.0, 0.4, 0.0, 0.0},
		{0.0, 0.0, 0.0, 0.6, 0.0, 0.0, 0.0, 0.4, 0.0},
		{0.0, 0.0, 0.0, 0.0, 0.6, 0.0, 0.0, 0.0, 0.4},
		{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.6, 0.0, 0.4},
		{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0}
		// "halfway" strategy
	 }; */
	 
	 /* LinkedHashMap<String, double[]> gamblingHash = new LinkedHashMap<String, double[]>();
	 gamblingHash.put("SL", gamblingStates[0]);
	 gamblingHash.put("S1", gamblingStates[1]);
	 gamblingHash.put("S2", gamblingStates[2]);
	 gamblingHash.put("S3", gamblingStates[3]);
	 gamblingHash.put("S4", gamblingStates[4]);
	 gamblingHash.put("S5", gamblingStates[5]);
	 gamblingHash.put("S6", gamblingStates[6]);
	 gamblingHash.put("S7", gamblingStates[7]);
	 gamblingHash.put("SW", gamblingStates[8]);
	 
	 System.out.println("Here's how the game starts (P^1):");
	 printLinkedHashMap(gamblingHash);
	 
	 System.out.println("\nHere's how the game looks after 100 moves (P^100):");
	 double[][] CG_100 = power_matrix(gamblingStates, 100);
	 gamblingHash.put("SL", CG_100[0]);
	 gamblingHash.put("S1", CG_100[1]);
	 gamblingHash.put("S2", CG_100[2]);
	 gamblingHash.put("S3", CG_100[3]);
	 gamblingHash.put("S4", CG_100[4]);
	 gamblingHash.put("S5", CG_100[5]);
	 gamblingHash.put("S6", CG_100[6]);
	 gamblingHash.put("S7", CG_100[7]);
	 gamblingHash.put("SW", CG_100[8]);
	 printLinkedHashMap(gamblingHash); */
	 
	 /* // Problem 4
	 double[][] crapStates = {
		{0.0, 4.0/36, 3.0/36, 4.0/36, 5.0/36, 5.0/36, 4.0/36, 3.0/36, 8.0/36},
		{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
		{0.0, 6.0/36, 27.0/36, 0.0, 0.0, 0.0, 0.0, 0.0, 3.0/36.0},
		{0.0, 6.0/36, 0.0, 26.0/36, 0.0, 0.0, 0.0, 0.0, 4.0/36},
		{0.0, 6.0/36, 0.0, 0.0, 25.0/36, 0.0, 0.0, 0.0, 5.0/36},
		{0.0, 6.0/36, 0.0, 0.0, 0.0, 25.0/36, 0.0, 0.0, 5.0/36},
		{0.0, 6.0/36, 0.0, 0.0, 0.0, 0.0, 26.0/36, 0.0, 4.0/36},
		{0.0, 6.0/36, 0.0, 0.0, 0.0, 0.0, 0.0, 27.0/36, 3.0/36},
		{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0}
	 };
	 
	 LinkedHashMap<String, double[]> crapHash = new LinkedHashMap<String, double[]>();
	 crapHash.put("I", crapStates[0]);
	 crapHash.put("L", crapStates[1]);
	 crapHash.put("4", crapStates[2]);
	 crapHash.put("5", crapStates[3]);
	 crapHash.put("6", crapStates[4]);
	 crapHash.put("8", crapStates[5]);
	 crapHash.put("9", crapStates[6]);
	 crapHash.put("10", crapStates[7]);
	 crapHash.put("W", crapStates[8]);
	 
	 System.out.println("Here's how the game starts (P^1):");
	 printLinkedHashMap(crapHash);
	 
	 System.out.println("\nHere's how the game looks after 100 moves (P^100):");
	 double[][] CG_100 = power_matrix(crapStates, 100);
	 crapHash.put("I", CG_100[0]);
	 crapHash.put("L", CG_100[1]);
	 crapHash.put("4", CG_100[2]);
	 crapHash.put("5", CG_100[3]);
	 crapHash.put("6", CG_100[4]);
	 crapHash.put("8", CG_100[5]);
	 crapHash.put("9", CG_100[6]);
	 crapHash.put("10", CG_100[7]);
	 crapHash.put("W", CG_100[8]);
	 printLinkedHashMap(crapHash); */
	 
	 /* // Problem 5
	 double[][] crapStates = {
		{0.0, 0.0, 1.0/36, 2.0/36, 3.0/36, 4.0/36, 5.0/36, 5.0/36, 4.0/36, 3.0/36, 2.0/36, 1.0/36, 6.0/36},
		{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0},
		{0.0, 6.0/36, 29.0/36, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0/36},
		{0.0, 6.0/36, 0.0, 28.0/36, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 2.0/36},
		{0.0, 6.0/36, 0.0, 0.0, 27.0/36, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 3.0/36},
		{0.0, 6.0/36, 0.0, 0.0, 0.0, 26.0/36, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 4.0/36},
		{0.0, 6.0/36, 0.0, 0.0, 0.0, 0.0, 25.0/36, 0.0, 0.0, 0.0, 0.0, 0.0, 5.0/36},
		{0.0, 6.0/36, 0.0, 0.0, 0.0, 0.0, 0.0, 25.0/36, 0.0, 0.0, 0.0, 0.0, 5.0/36},
		{0.0, 6.0/36, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 26.0/36, 0.0, 0.0, 0.0, 4.0/36},
		{0.0, 6.0/36, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 27.0/36, 0.0, 0.0, 3.0/36},
		{0.0, 6.0/36, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 28.0/36, 0.0, 2.0/36},
		{0.0, 6.0/36, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 29.0/36, 1.0/36},
		{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0}
	 };
	 
	 LinkedHashMap<String, double[]> crapHash = new LinkedHashMap<String, double[]>();
	 crapHash.put("I", crapStates[0]);
	 crapHash.put("L", crapStates[1]);
	 crapHash.put("2", crapStates[2]);
	 crapHash.put("3", crapStates[3]);
	 crapHash.put("4", crapStates[4]);
	 crapHash.put("5", crapStates[5]);
	 crapHash.put("6", crapStates[6]);
	 crapHash.put("8", crapStates[7]);
	 crapHash.put("9", crapStates[8]);
	 crapHash.put("10", crapStates[9]);
	 crapHash.put("11", crapStates[10]);
	 crapHash.put("12", crapStates[11]);
	 crapHash.put("W", crapStates[12]);
	 
	 System.out.println("Here's how the game starts (P^1):");
	 printLinkedHashMap(crapHash);
	 
	 System.out.println("\nHere's how the game looks after 100 moves (P^100):");
	 double[][] CG_100 = power_matrix(crapStates, 100);
	 crapHash.put("I", CG_100[0]);
	 crapHash.put("L", CG_100[1]);
	 crapHash.put("2", CG_100[2]);
	 crapHash.put("3", CG_100[3]);
	 crapHash.put("4", CG_100[4]);
	 crapHash.put("5", CG_100[5]);
	 crapHash.put("6", CG_100[6]);
	 crapHash.put("8", CG_100[7]);
	 crapHash.put("9", CG_100[8]);
	 crapHash.put("10", CG_100[9]);
	 crapHash.put("11", CG_100[10]);
	 crapHash.put("12", CG_100[11]);
	 crapHash.put("W", CG_100[12]);
	 printLinkedHashMap(crapHash); */
	 
	 // Problem 6	 
	 HashMap<Integer, int[]> adj = new HashMap<Integer, int[]>();
	 adj.put(0, new int[] {7, 9});
	 adj.put(1, new int[] {5, 11});
	 adj.put(2, new int[] {8, 11});
	 adj.put(3, new int[] {8, 10});
	 adj.put(4, new int[] {7, 8, 10, 11});
	 adj.put(5, new int[] {1, 6, 9, 10});
	 adj.put(6, new int[] {5, 8});
	 adj.put(7, new int[] {0, 4, 9});
	 adj.put(8, new int[] {2, 3, 4, 6});
	 adj.put(9, new int[] {0, 5, 7});
	 adj.put(10,new int[] {3, 4, 5});
	 adj.put(11,new int[] {1, 2, 4});
	 
	 boolean[][] booArr = HashMapTo2DBooleanArray(adj);
	 System.out.println("Here's your logical matrix:");
	 printArray(booArr);
	 boolean [][] product = power_matrix(booArr, 2);
	 System.out.println("Here's the boolean product:");
	 printArray(product);
	 boolean[][] cubed = power_matrix(booArr, 3);
	 System.out.println("Here's your array cubed:");
	 printArray(cubed);
	 boolean[][] fourth = power_matrix(booArr, 4);
	 System.out.println("Here's your array ^fourth:");
	 printArray(fourth);
	 
	 
	 // Display a Goodbye note
	 System.out.println("Goodbye!");

 } // end method main
 
} // end class