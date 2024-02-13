/* Filename: Exam2.java
 * Author: Taylor Marrion
 * Date: March 1, 2022
 * Purpose: 
 */
 
 // Import statements
 import java.util.*;
 /* import java.util.Arrays;
 import java.util.HashMap;
 import java.util.LinkedHashMap;
 import java.util.Random;
 import java.util.Set; */
 import java.io.File;
 import java.io.FileNotFoundException;

/**
* 
*/
public class Exam2 {
	
	static final int BYTE_LENGTH = 8;
	
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
	} // end getIdentityMatrix_double
	
	static int[][] power_matrix(int[][] arr, int r){
		int n = arr.length;
		int[][] result = getIdentityMatrix(n);
		
		while (r > 0) {
			if (r % 2 == 1) {
				result = multMatrix(result, arr);
			}
			arr = multMatrix(arr, arr);
			r = r/2;
		}
		return result;
	} // end power_matrix
	
	static double[][] power_matrix(double[][] arr, int r){
		int n = arr.length;
		double[][] result = getIdentityMatrix_double(n);
		
		while (r > 0) {
			if (r % 2 == 1) {
				result = multMatrix(result, arr);
			}
			arr = multMatrix(arr, arr);
			r = r/2;
		}
		return result;
	} // end power_matrix
	
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
	
	/*  */
	static int[][] transposeMatrix (int[][] arr){
		int n = arr.length;
		int m = arr[0].length;
		int[][] result = new int[n][m];
		for (int i = 0; i < n; i++){
			for (int j = 0; j < m; j++){
				result[i][j] = arr[j][i];
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
	
	/*  */ 
	static int hammingDistance (int[]a, int[]b){
		int result = 0;
		
		for (int i = 0; i < a.length; i++){
			result += (a[i] ^ b[i]);
		}
		
		return result;
	} // end hammingDistance
	
	/*  */ 
	static int[][] generateAllMessages (int m){
		int[][] result = new int[1 << m][m];	// [2^m][m]
		
		for (int i = 0, bin = 0b0000; i < result.length; i++, bin++){
			int temp = bin;
			for (int j = 0; j < result[i].length; j++){
				result[i][result[i].length - j - 1] = (1 & temp);
				temp >>= 1;
			}
		}
		
		return result;
	} // end generateAllMessages
	
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
	/* static void printLinkedHashMap(LinkedHashMap<String, double[]> map) {
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
	} // end printLinkedHashMap */
	
	/* OVERLOADED: A utility function to print a transition matrix stored in a LinkedHashMap of size of n*n where n is the number of states */
	static void printLinkedHashMap(LinkedHashMap<String, ArrayList<String>> map) {
		Set<String> keys = map.keySet();
		Iterator<String> iterator = keys.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			if (!iterator.hasNext()) {
				System.out.print(String.format("\n"));
			}
		}
	 
		iterator = keys.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			ArrayList<String> list = map.get(str);
			String arrString = "[";
			for (int i = 0; i < list.size(); i++) {
				arrString += String.format("%s, ", list.get(i));
			}
			arrString = arrString.substring(0, arrString.length()-2);
			arrString += "]";
			str = String.format("%s: %s", str, arrString);
			System.out.println(str);
		}
	} // end printLinkedHashMap
	
	/* reverse bits, retaining length of n bits */
	static int reverseBits(int x, int n){
		int result = 0;
		for (int i = 0; i < n; i++){
			result <<= 1;
			result += (x & 1);
			x >>= 1;
		}
		return result;
	} // end reverseBits
	
	static int badHashV3(String str){
		int result = 0;
		byte[] arr = str.getBytes();
		
		for (int i = 0; i < arr.length; i++){
			result ^= arr[i];
			result = reverseBits(result, BYTE_LENGTH);
			
			//String hashBits = String.format("%8s", Integer.toBinaryString(result)).replace(' ', '0');
			//String line = String.format("round %d: %3d = 0b%s", (i+1), result, hashBits);
			//System.out.println(line);
		}
		
		return result;
	} // end badHashV3
	
	static String randomString(){
		
		String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
		
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 10;
		
		for(int i = 0; i < length; i++) {
			int index = random.nextInt(alphaNumeric.length());
			char randomChar = alphaNumeric.charAt(index);
			sb.append(randomChar);
		}
		
		return sb.toString();
	} // end randomString
	
 public static void main(String[] args) {
	 
	 // Display a Welcome note
	 System.out.println("Hi!");
	 
	 // Start code
	 
	 // Problem 1
	 /* System.out.println("\n========= Problem 1 - Part d =========");
	 HashMap<Integer, int[]> map_1 = new HashMap<Integer, int[]>();
	 map_1.put(0, new int[] {1, 3});
	 map_1.put(1, new int[] {0, 2, 4, 8});
	 map_1.put(2, new int[] {1, 3, 5, 6, 9});
	 map_1.put(3, new int[] {0, 2, 6, 8});
	 map_1.put(4, new int[] {1, 9});
	 map_1.put(5, new int[] {2, 7, 8});
	 map_1.put(6, new int[] {2, 3, 8, 9});
	 map_1.put(7, new int[] {5, 9});
	 map_1.put(8, new int[] {1, 3, 5, 6, 9});
	 map_1.put(9, new int[] {2, 4, 6, 7, 8});
	 
	 int[][] adj_1 = HashMapTo2DArray(map_1);
	 
	 System.out.println("Adjacency matrix: A = ");
	 System.out.println(Arrays.deepToString(adj_1).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
	 
	 System.out.println("\n========= Problem 1 - Part e =========");
	 int[][] adj_1_cubed = power_matrix(adj_1, 3);
	 System.out.println("A^3 = ");
	 printArray(adj_1_cubed);
	 System.out.println("Paths of length 3 from 0 to 9: " + adj_1_cubed[0][9]);
	 
	 System.out.println("\n========= Problem 1 - Part f =========");
	 int[][] adj_1_fourth = power_matrix(adj_1, 4);
	 System.out.println("A^4 = ");
	 printArray(adj_1_fourth);
	 System.out.println("Paths of length 4 from 0 to 9: " + adj_1_fourth[0][9]); */
	 
	 // Problem 2
	 /* System.out.println("\n========= Problem 2 - Part d =========");
	 HashMap<Integer, int[]> map_2 = new HashMap<Integer, int[]>();
	 map_2.put(0, new int[] {1, 3});
	 map_2.put(1, new int[] {2, 8});
	 map_2.put(2, new int[] {3, 5, 9});
	 map_2.put(3, new int[] {6, 8});
	 map_2.put(4, new int[] {1});
	 map_2.put(5, new int[] {7});
	 map_2.put(6, new int[] {2, 8});
	 map_2.put(7, new int[] {9});
	 map_2.put(8, new int[] {5, 9});
	 map_2.put(9, new int[] {4, 6});
	 
	 int[][] adj_2 = HashMapTo2DArray(map_2);
	 
	 System.out.println("Adjacency matrix: A = ");
	 System.out.println(Arrays.deepToString(adj_2).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
	 
	 System.out.println("\n========= Problem 2 - Part e =========");
	 int[][] adj_2_cubed = power_matrix(adj_2, 3);
	 System.out.println("A^3 = ");
	 printArray(adj_2_cubed);
	 System.out.println("Paths of length 3 from 0 to 9: " + adj_2_cubed[0][9]);
	 
	 System.out.println("\n========= Problem 2 - Part f =========");
	 int[][] adj_2_fifth = power_matrix(adj_2, 5);
	 System.out.println("A^5 = ");
	 printArray(adj_2_fifth);
	 System.out.println("Paths of length 5 from 0 to 9: " + adj_2_fifth[0][9]);
	 
	 System.out.println("\n========= Problem 2 - Part g =========");
	 int[][] adj_2_sixth = power_matrix(adj_2, 6);
	 System.out.println("A^6 = ");
	 printArray(adj_2_sixth);
	 System.out.println("Paths of length 6 from 0 to 9: " + adj_2_sixth[0][9]); */
	 
	 // Problem 3
	 /* System.out.println("\n========= Problem 3 - Part a =========");
	 System.out.println("Playing fair");
	 double[][] coinStates_a = {
		{1.0, 0.0, 0.0, 0.0, 0.0},
		{1.0/3, 0.0, 1.0/3, 1.0/3, 0.0},
		{0.0, 1.0/3, 1.0/3, 1.0/3, 0.0},
		{0.0, 1.0/3, 1.0/3, 0.0, 1.0/3},
		{0.0, 0.0, 0.0, 0.0, 1.0}
	 };
	 
	 LinkedHashMap<String, double[]> coinHash_a = new LinkedHashMap<String, double[]>();
	 coinHash_a.put("SL", coinStates_a[0]);
	 coinHash_a.put("S1", coinStates_a[1]);
	 coinHash_a.put("S2", coinStates_a[2]);
	 coinHash_a.put("S3", coinStates_a[3]);
	 coinHash_a.put("SW", coinStates_a[4]);
	 
	 System.out.println("P = ");
	 printLinkedHashMap(coinHash_a);
	 
	 double[][] coinStates_a_100 = power_matrix(coinStates_a, 100);
	 coinHash_a.put("SL", coinStates_a_100[0]);
	 coinHash_a.put("S1", coinStates_a_100[1]);
	 coinHash_a.put("S2", coinStates_a_100[2]);
	 coinHash_a.put("S3", coinStates_a_100[3]);
	 coinHash_a.put("SW", coinStates_a_100[4]);
	 
	 System.out.println("P^100 = ");
	 printLinkedHashMap(coinHash_a);
	 
	 System.out.println("\n========= Problem 3 - Part b =========");
	 System.out.println("Tipped off");
	 double[][] coinStates_b = {
		{1.0, 0.0, 0.0, 0.0, 0.0},
		{1.0/4, 0.0, 1.0/2, 1.0/4, 0.0},
		{0.0, 1.0/3, 1.0/3, 1.0/3, 0.0},
		{0.0, 1.0/3, 1.0/3, 0.0, 1.0/3},
		{0.0, 0.0, 0.0, 0.0, 1.0}
	 };
	 
	 LinkedHashMap<String, double[]> coinHash_b = new LinkedHashMap<String, double[]>();
	 coinHash_b.put("SL", coinStates_b[0]);
	 coinHash_b.put("S1", coinStates_b[1]);
	 coinHash_b.put("S2", coinStates_b[2]);
	 coinHash_b.put("S3", coinStates_b[3]);
	 coinHash_b.put("SW", coinStates_b[4]);
	 
	 System.out.println("P = ");
	 printLinkedHashMap(coinHash_b);
	 
	 double[][] coinStates_b_100 = power_matrix(coinStates_b, 100);
	 coinHash_b.put("SL", coinStates_b_100[0]);
	 coinHash_b.put("S1", coinStates_b_100[1]);
	 coinHash_b.put("S2", coinStates_b_100[2]);
	 coinHash_b.put("S3", coinStates_b_100[3]);
	 coinHash_b.put("SW", coinStates_b_100[4]);
	 
	 System.out.println("P^100 = ");
	 printLinkedHashMap(coinHash_b);
	 
	 System.out.println("\n========= Problem 3 - Part c =========");
	 System.out.println("Better?");
	 double[][] coinStates_c = {
		{1.0, 0.0, 0.0, 0.0, 0.0},
		{1.0/4, 0.0, 1.0/4, 1.0/2, 0.0},
		{0.0, 1.0/3, 1.0/3, 1.0/3, 0.0},
		{0.0, 1.0/3, 1.0/3, 0.0, 1.0/3},
		{0.0, 0.0, 0.0, 0.0, 1.0}
	 };
	 
	 LinkedHashMap<String, double[]> coinHash_c = new LinkedHashMap<String, double[]>();
	 coinHash_c.put("SL", coinStates_c[0]);
	 coinHash_c.put("S1", coinStates_c[1]);
	 coinHash_c.put("S2", coinStates_c[2]);
	 coinHash_c.put("S3", coinStates_c[3]);
	 coinHash_c.put("SW", coinStates_c[4]);
	 
	 System.out.println("P = ");
	 printLinkedHashMap(coinHash_c);
	 
	 double[][] coinStates_c_100 = power_matrix(coinStates_c, 100);
	 coinHash_c.put("SL", coinStates_c_100[0]);
	 coinHash_c.put("S1", coinStates_c_100[1]);
	 coinHash_c.put("S2", coinStates_c_100[2]);
	 coinHash_c.put("S3", coinStates_c_100[3]);
	 coinHash_c.put("SW", coinStates_c_100[4]);
	 
	 System.out.println("P^100 = ");
	 printLinkedHashMap(coinHash_c); */
	 
	 // Problem 4
	 /* System.out.println("\n========= Problem 4 - Set Up =========");
	 String fullText = "";
	 try {
		 Scanner myReader = new Scanner(new File("text2.txt"));
		 while (myReader.hasNextLine()){
			 fullText += myReader.nextLine() + " ";
		 }
		 myReader.close();
	 } catch (FileNotFoundException e) {
		 System.out.println("File not found!");
	 }
	 
	 LinkedHashMap<String, ArrayList<String>> wordHash = new LinkedHashMap<String, ArrayList<String>>();
	 String[] allWords = fullText.split(" ");
	 
	 for (int i = 0; i < allWords.length; i++){
		 if (wordHash.containsKey(allWords[i])) {
			 ArrayList<String> temp = wordHash.get(allWords[i]);
			 if (i == allWords.length - 1) {
				 temp.add(allWords[0]);
			 } else {
				 temp.add(allWords[i+1]);
			 }
			 wordHash.put(allWords[i], temp);
		 } else {
			 ArrayList<String> temp = new ArrayList<String>();
			 if (i == allWords.length - 1) {
				 temp.add(allWords[0]);
			 } else {
				 temp.add(allWords[i+1]);
			 }
			 wordHash.put(allWords[i], temp);
		 }
	 }
	 
	 printLinkedHashMap(wordHash);
	 
	 System.out.println("\n========= Problem 4 - Part b,c,d =========");
	 System.out.println("=== Randomly generated sentences ===");
	 Object[] keys = wordHash.keySet().toArray();
	 //char endChar = '';
	 for (int i = 0; i < 3; i++){
		 String newStr = "";
		 char endChar = ' ';
		 do {
			 newStr += (" " + keys[new Random().nextInt(keys.length)]);
			 endChar = (newStr.charAt(newStr.length() - 1));
		 } while (endChar != '.' && endChar != '!' && endChar != '?'); // check for punctuation
		 
		 System.out.println(newStr.substring(1)); // remove leading blank space
	 } */
	 
	 // Problem 5
	 /* System.out.println("\n========= Problem 5 - Set Up =========");
	 // String to array of chars
	 String str_0 = "Hash";
	 char[] arr_0 = str_0.toCharArray();
	 System.out.println(Arrays.toString(arr_0));
	 byte[] bytes_0 = str_0.getBytes();
	 System.out.println(Arrays.toString(bytes_0));
	 
	 // test badHashV3
	 int hash_0 = badHashV3(str_0);
	 String hashBits_0 = String.format("%8s", Integer.toBinaryString(hash_0)).replace(' ', '0');
	 System.out.println("BadHashv3 of \"" + str_0 + "\": " + hash_0 + " = 0b" + hashBits_0);
	 
	 System.out.println("\n========= Problem 5 - Part a =========");
	 // String to array of chars
	 String str_1 = "Cyber";
	 char[] arr_1 = str_1.toCharArray();
	 System.out.println(Arrays.toString(arr_1));
	 byte[] bytes_1 = str_1.getBytes();
	 System.out.println(Arrays.toString(bytes_1));
	 
	 // test badHashV3
	 int hash_1 = badHashV3(str_1);
	 String hashBits_1 = String.format("%8s", Integer.toBinaryString(hash_1)).replace(' ', '0');
	 System.out.println("BadHashv3 of \"" + str_1 + "\": " + hash_1 + " = 0b" + hashBits_1);
	 
	 System.out.println("\n========= Problem 5 - Part c =========");
	 HashMap<Integer, String> stringHashes = new HashMap<Integer, String>();
	 for (int i = 0; i < 16; i++){
		 String tempStr = randomString();
		 int tempHash = badHashV3(tempStr);
		 
		 if (stringHashes.containsKey(tempHash)){
			 System.out.println("Collision!");
		 }
		 
		 stringHashes.put(tempHash, tempStr);
		 String tempHashBits = String.format("%8s", Integer.toBinaryString(tempHash)).replace(' ', '0');
		 System.out.println("BadHashV3 of \"" + tempStr + "\": " + tempHash + " = 0b" + tempHashBits);
	 } */
	 
	 // Problem 6
	 /* System.out.println("\n========= Problem 6A - Set Up =========");
	 // generating matrix
	 int[][] G = {
		 {1,0,0,0,1,1,1},
		 {0,1,0,0,0,1,1},
		 {0,0,1,0,1,0,1},
		 {0,0,0,1,1,1,0}
	 };
	 
	 // parity check matrix
	 int[][] Ht = {
		 {1,1,1},
		 {0,1,1},
		 {1,0,1},
		 {1,1,0},
		 {1,0,0},
		 {0,1,0},
		 {0,0,1}
	 };
	 
	 System.out.println("\n========= Problem 6A - Part a =========");
	 // k * k permutation matrix
	 int[][] S = {
		 {0,1,0,0},
		 {0,0,1,0},
		 {1,0,0,0},
		 {0,0,0,1}
	 };
	 
	 // n * n permutation matrix
	 int[][] P = {
		 {0,1,0,0,0,0,0},
		 {0,0,0,0,0,0,1},
		 {1,0,0,0,0,0,0},
		 {0,0,0,0,1,0,0},
		 {0,0,0,0,0,1,0},
		 {0,0,0,1,0,0,0},
		 {0,0,1,0,0,0,0}
	 };
	 
	 int k = 4;
	 int n = 7;
	 int r = 3;
	 
	 System.out.println("Message length: k = " + k);
	 System.out.println("Codeword length: n = " + n);
	 System.out.println("Redundancies: r = " + r);
	 System.out.println("H^t = ");
	 printArray(Ht);
	 System.out.println("G = ");
	 printArray(G);
	 System.out.println("S = ");
	 printArray(S);
	 System.out.println("P = ");
	 printArray(P);
	 
	 int[][] SG = multMatrix(S,G);
	 mod2(SG);
	 int[][] G1 = multMatrix(SG,P);
	 mod2(G1);
	 System.out.println("G1 = SGP =");
	 printArray(G1);
	 
	 System.out.println("\n========= Problem 6A - Part b =========");
	 int[][] m = {{1,0,0,1}};	// message to be encrypted
	 System.out.println("m =");
	 printArray(m);
	 int[][] c = multMatrix(m, G1);
	 mod2(c);
	 System.out.println("c = m*G1 = ");
	 printArray(c);
	 int bitToChange = 3;
	 c[0][bitToChange] = ((c[0][bitToChange])+1)%2;
	 System.out.println("c (after changing a bit) =");
	 printArray(c);
	 
	 //System.out.println("\n========= Problem 6A - Part c =========");
	 System.out.println("\n========= Problem 6B - Part e =========");
	 c[0][0] = 1;	// manual entry
	 c[0][1] = 0;
	 c[0][2] = 1;
	 c[0][3] = 0;
	 c[0][4] = 1;
	 c[0][5] = 1;
	 c[0][6] = 1;
	 System.out.println("manual entry of c =");
	 printArray(c);
	 
	 int[][] Pt = transposeMatrix(P);
	 System.out.println("P^t = ");
	 printArray(Pt);
	 int[][] c1 = multMatrix(c,Pt);
	 System.out.println("c1 = cP^t =  ");
	 printArray(c1);
	 int[][] syndrome = multMatrix(c1, Ht);
	 mod2(syndrome);
	 System.out.println("syndrome = cH^t = ");
	 printArray(syndrome);
	 int indexOfSyndrome = findIndexOfSyndrome(syndrome, Ht);
	 System.out.println("index of syndrome in H^t = " + indexOfSyndrome);
	 c1[0][indexOfSyndrome] = ((c1[0][indexOfSyndrome])+1)%2;
	 System.out.println("x1 = c1 (after changing a bit) = ");
	 printArray(c1);
	 int[][] x0 = new int[1][S.length];
	 for (int i = 0; i < x0[0].length; i++){
		 x0[0][i] = c1[0][i];
	 }
	 System.out.println("x0 = first k bits of x1 = ");
	 printArray(x0);
	 int[][] St = transposeMatrix(S);
	 System.out.println("S^t = ");
	 printArray(St);
	 int[][] decoded = multMatrix(x0,St);
	 mod2(decoded);
	 System.out.println("Decoded message = x0 * S^t = ");
	 printArray(decoded);
	 
	 int num = 0;
	 for (int i = 0; i < decoded[0].length; i++){
		 num <<= 1;
		 num += (decoded[0][i] & 1);
	 }
	 System.out.println("Decoded message = " + num + " = 0b" + Integer.toBinaryString(num));
	 
	 System.out.println("\n========= Problem 6B - Part e ========="); */
	 
	 // Problem 7
	 System.out.println("\n========= Problem 7 - Part b =========");
	 int max = Integer.MAX_VALUE;
	 int[] distances = {0, max, max, max, max, max, max};	// Can't initialize as infinity so MAX_VALUE will have to work.
	 final int[][] graph = {
		 {0, 20, 13, 37, 0, 0, 0},		// S
		 {0, 0, 0, 0, 2, -6, 0},		// A
		 {0, 0, 0, 0, 42, 0, 0},		// B
		 {0, 0, -9, 0, 0, 0, 5},		// C
		 {0, 0, 0, 0, 0, 0, 5},			// D
		 {0, 0, 0, 0, 7, 0, 0},			// E
		 {0, 0, 0, -3, 0, -1, 0}		// F
	 };		// "0" is either itself or not connected
	 int v = graph.length;
	 int iterations = 0;
	 for (int i = 0; i < (v-1); i++){			// (v - 1) total iterations
	 int changes = 0;							// stop when no changes made
		 for (int j = 0; j < v; j++){			// each vertex
			 for (int k = 0; k < v; k++){		// each connection of vertex j
				 if (graph[j][k] == 0){
				 continue;	//	skip this
				 } else if (distances[k] > (graph[j][k] + distances[j]) && (graph[j][k] + distances[j]) > 0) {
					 // ensure no negative cycles make it to result
					 distances[k] = (graph[j][k] + distances[j]);
					 changes++;
				 }
			 }
		 }
		 iterations++;
		 if (changes == 0){
			 break;
		 }
	 }
	 System.out.println("Iterations needed: " + iterations);
	 System.out.println("Distances from S: " + Arrays.toString(distances));
	 
	 // Display a Goodbye note
	 System.out.println("\nGoodbye!");

 } // end method main
 
} // end class