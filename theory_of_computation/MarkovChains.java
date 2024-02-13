/* Filename: MarkovChains.java
 * Author: Taylor Marrion
 * Date: March 1, 2022
 * Purpose: 
 */
 
 // Import statements
 import java.util.*;

/**
* 
*/
public class MarkovChains {
	
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
	 /* double r = 0.1;	//0.2;	// less infectious, but...
	 double h = 0.05;	//0.1;	// harder to heal
	 double z = 0.5;
	 double b = 0.1;	//0.2;	// harder to recover
	 
	 double S_S = 1 - r;
	 double S_I = r;
	 double S_Z = 0;
	 double I_S = h;
	 double I_I = 1 - h - z;
	 double I_Z = z;
	 double Z_S = 0;
	 double Z_I = b;
	 double Z_Z = 1 - b;
	 
	 double[][] zombies = {
		 {S_S,S_I,S_Z},
		 {I_S,I_I,I_Z},
		 {Z_S,Z_I,Z_Z}
	 };
	 
	 LinkedHashMap<Character, double[]> zombiesHash = new LinkedHashMap<Character, double[]>();
	 zombiesHash.put('S', zombies[0]);
	 zombiesHash.put('I', zombies[1]);
	 zombiesHash.put('Z', zombies[2]);
	 
	 System.out.println("Here's how the Zombie apocalypse starts (P^1):");
	 printLinkedHashMap(zombiesHash);
	 
	 System.out.println("\nHere's how the Zombie apocalypse shapes up (P^1000):");
	 double[][] Z_1000 = power_matrix(zombies, 1000);
	 zombiesHash.put('S', Z_1000[0]);
	 zombiesHash.put('I', Z_1000[1]);
	 zombiesHash.put('Z', Z_1000[2]);
	 printLinkedHashMap(zombiesHash); */
	 
	 double[][] cardStates = {
		 {1, 0, 0, 0, 0, 0, 0, 0},
		 {1.0/3, 0, 0, 0, 1.0/3, 1.0/3, 0, 0},
		 {1.0/3, 0, 0, 0, 1.0/3, 0, 1.0/3, 0},
		 {1.0/3, 0, 0, 0, 0, 1.0/3, 1.0/3, 0},
		 {0, 1.0/3, 1.0/3, 0, 0, 0, 0, 1.0/3},
		 {0, 1.0/3, 0, 1.0/3, 0, 0, 0, 1.0/3},
		 {0, 0, 1.0/3, 1.0/3, 0, 0, 0, 1.0/3},
		 {0, 0, 0, 0, 0, 0, 0, 1}
	 };
	 
	 LinkedHashMap<String, double[]> cardHash = new LinkedHashMap<String, double[]>();
	 cardHash.put("SL", cardStates[0]);
	 cardHash.put("S1", cardStates[1]);
	 cardHash.put("S2", cardStates[2]);
	 cardHash.put("S3", cardStates[3]);
	 cardHash.put("S12", cardStates[4]);
	 cardHash.put("S13", cardStates[5]);
	 cardHash.put("S23", cardStates[6]);
	 cardHash.put("SW", cardStates[7]);
	 
	 System.out.println("Here's how the card game starts (P^1):");
	 printLinkedHashMap(cardHash);
	 
	 System.out.println("\nHere's how the game looks after 100 moves (P^100):");
	 double[][] CG_100 = power_matrix(cardStates, 100);
	 cardHash.put("SL", CG_100[0]);
	 cardHash.put("S1", CG_100[1]);
	 cardHash.put("S2", CG_100[2]);
	 cardHash.put("S3", CG_100[3]);
	 cardHash.put("S12", CG_100[4]);
	 cardHash.put("S13", CG_100[5]);
	 cardHash.put("S23", CG_100[6]);
	 cardHash.put("SW", CG_100[7]);
	 printLinkedHashMap(cardHash);
	 
	 // Display a Goodbye note
	 System.out.println("Goodbye!");

 } // end method main
 
} // end class