/* Filename: AP15.java
 * Author: Taylor Marrion
 * Date: March 1, 2022
 * Purpose: 
 */
 
 // Import statements
 //import java.util.*;
 import java.util.Arrays;
 import java.lang.Math;

/**
* 
*/
public class AP15 {
	
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
	
	/* rotate matrix left 90 degrees */
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
	} // end hammingDistance
	
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
	 
	 // Problem 1
	 // generating matrix
	 int[][] G_1 = {
		 {1,0,0,0,1,1,1},
		 {0,1,0,0,0,1,1},
		 {0,0,1,0,1,0,1},
		 {0,0,0,1,1,1,0}
	 };
	 
	 // parity check matrix
	 int[][] Ht_1 = {
		 {1,1,1},
		 {0,1,1},
		 {1,0,1},
		 {1,1,0},
		 {1,0,0},
		 {0,1,0},
		 {0,0,1}
	 };
	 
	 // k * k permutation matrix
	 int[][] S_1 = {
		 {0,1,0,0},
		 {0,0,0,1},
		 {1,0,0,0},
		 {0,0,1,0}
	 };
	 
	 // n * n permutation matrix
	 int[][] P_1 = {
		 {0,0,1,0,0,0,0},
		 {1,0,0,0,0,0,0},
		 {0,0,0,0,1,0,0},
		 {0,0,0,0,0,0,1},
		 {0,0,0,0,0,1,0},
		 {0,1,0,0,0,0,0},
		 {0,0,0,1,0,0,0}
	 };
	 
	 int k_1 = 4;
	 int n_1 = 7;
	 int r_1 = 3;
	 
	 System.out.println("\n========= Problem 1 - Set Up =========");
	 System.out.println("Everything in this section is \"public knowledge\"");
	 System.out.println("Message length: k = " + k_1);
	 System.out.println("Codeword length: n = " + n_1);
	 System.out.println("Redundancies: r = " + r_1);
	 System.out.println("Ht = ");
	 printArray(Ht_1);
	 System.out.println("G = ");
	 printArray(G_1);
	 
	 System.out.println("\n========= Problem 1 - Part a =========");
	 int[][] SG_1 = multMatrix(S_1,G_1);
	 mod2(SG_1);
	 int[][] G1_1 = multMatrix(SG_1,P_1);
	 mod2(G1_1);
	 System.out.println("G1 = SGP =");
	 printArray(G1_1);

	 System.out.println("\n========= Problem 1 - Part b =========");
	 //int[][] m_1 = {{1,1,0,1}};	// used to test against example in videos
	 int[][] m_1 = {{1,0,0,1}};	// message to be encrypted
	 System.out.println("m =");
	 printArray(m_1);
	 int[][] c_1 = multMatrix(m_1, G1_1);
	 mod2(c_1);
	 System.out.println("c (before changing a bit) =");
	 printArray(c_1);
	 int bitToChange_1 = 3;
	 c_1[0][bitToChange_1] = ((c_1[0][bitToChange_1])+1)%2;
	 System.out.println("c (after changing a bit) =");
	 printArray(c_1);
	 
	 System.out.println("\n========= Problem 1 - Part c =========");
	 int[][] Pt_1 = transposeMatrix(P_1);
	 System.out.println("P^t: ");
	 printArray(Pt_1);
	 int[][] c1_1 = multMatrix(c_1,Pt_1);
	 System.out.println("c1 = cP^t: ");
	 printArray(c1_1);
	 int[][] syndrome_1 = multMatrix(c1_1, Ht_1);
	 mod2(syndrome_1);
	 System.out.println("syndrome = cH^t: ");
	 printArray(syndrome_1);
	 int indexOfSyndrome_1 = findIndexOfSyndrome(syndrome_1, Ht_1);
	 System.out.println("index of syndrome in H^t: " + indexOfSyndrome_1);
	 c1_1[0][indexOfSyndrome_1] = ((c1_1[0][indexOfSyndrome_1])+1)%2;
	 System.out.println("x1 = c1 (after changing a bit): ");
	 printArray(c1_1);
	 int[][] x0_1 = new int[1][S_1.length];
	 for (int i = 0; i < x0_1[0].length; i++){
		 x0_1[0][i] = c1_1[0][i];
	 }
	 System.out.println("x0 = first k bits of x1: ");
	 printArray(x0_1);
	 int[][] St_1 = transposeMatrix(S_1);
	 System.out.println("S^t: ");
	 printArray(St_1);
	 int[][] decoded_1 = multMatrix(x0_1,St_1);
	 mod2(decoded_1);
	 System.out.println("Decoded message = x0 * S^t: ");
	 printArray(decoded_1);
	 
	 
	  // Problem 2
	 // generating matrix
	 int[][] G_2 = {
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
	 
	 // parity check matrix
	 int[][] Ht_2 = {
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
	 
	 // k * k permutation matrix
	 int[][] S_2 = {
		 {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
		 {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
		 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		 {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
		 {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
		 {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
		 {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
		 {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
		 {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
		 {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}
	 };
	 
	 // n * n permutation matrix
	 int[][] P_2 = {
		 {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
		 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
		 {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		 {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
		 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
		 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
		 {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		 {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
		 {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		 {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
		 {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
		 {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		 {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}
	 };
	 
	 int k_2 = 11;
	 int n_2 = 15;
	 int r_2 = 4;
	 
	 System.out.println("\n========= Problem 2 - Set Up =========");
	 System.out.println("Everything in this section is \"public knowledge\"");
	 System.out.println("Message length: k = " + k_2);
	 System.out.println("Codeword length: n = " + n_2);
	 System.out.println("Redundancies: r = " + r_2);
	 System.out.println("Ht = ");
	 printArray(Ht_2);
	 System.out.println("G = ");
	 printArray(G_2);
	 
	 System.out.println("\n========= Problem 1 - Part a =========");
	 int[][] SG_2 = multMatrix(S_2,G_2);
	 mod2(SG_2);
	 int[][] G1_2 = multMatrix(SG_2,P_2);
	 mod2(G1_2);
	 System.out.println("G1 = SGP =");
	 printArray(G1_2);

	 System.out.println("\n========= Problem 1 - Part b =========");
	 int[][] m_2 = {{1,0,1,0,0,1,1,1,0,0,1}};	// message to be encrypted
	 System.out.println("m =");
	 printArray(m_2);
	 int[][] c_2 = multMatrix(m_2, G1_2);
	 mod2(c_2);
	 System.out.println("c (before changing a bit) =");
	 printArray(c_2);
	 int bitToChange_2 = 7;
	 c_2[0][bitToChange_2] = ((c_2[0][bitToChange_2])+1)%2;
	 System.out.println("c (after changing a bit) =");
	 printArray(c_2);
	 
	 System.out.println("\n========= Problem 1 - Part c =========");
	 int[][] Pt_2 = transposeMatrix(P_2);
	 System.out.println("P^t: ");
	 printArray(Pt_2);
	 int[][] c1_2 = multMatrix(c_2,Pt_2);
	 System.out.println("c1 = cP^t: ");
	 printArray(c1_2);
	 int[][] syndrome_2 = multMatrix(c1_2, Ht_2);
	 mod2(syndrome_2);
	 System.out.println("syndrome = cH^t: ");
	 printArray(syndrome_2);
	 int indexOfSyndrome_2 = findIndexOfSyndrome(syndrome_2, Ht_2);
	 System.out.println("index of syndrome in H^t: " + indexOfSyndrome_2);
	 c1_2[0][indexOfSyndrome_2] = ((c1_2[0][indexOfSyndrome_2])+1)%2;
	 System.out.println("x1 = c1 (after changing a bit): ");
	 printArray(c1_2);
	 int[][] x0_2 = new int[1][S_2.length];
	 for (int i = 0; i < x0_2[0].length; i++){
		 x0_2[0][i] = c1_2[0][i];
	 }
	 System.out.println("x0 = first k bits of x1: ");
	 printArray(x0_2);
	 int[][] St_2 = transposeMatrix(S_2);
	 System.out.println("S^t: ");
	 printArray(St_2);
	 int[][] decoded_2 = multMatrix(x0_2,St_2);
	 mod2(decoded_2);
	 System.out.println("Decoded message = x0 * S^t: ");
	 printArray(decoded_2);
	 
	 int num = 0;
	 for (int i = 0; i < decoded_2[0].length; i++){
		 num <<= 1;
		 num += (decoded_2[0][i] & 1);
	 }
	 System.out.println("Decoded message to int: " + num);
	 
	 System.out.println("\n========= Problem 3 - Part a =========");
	 int[] ex_1a = {1,1,0,1};
	 int[] ex_1b = {1,0,0,1};
	 int[] ex_2b = {1,0,0,0};
	 int[] ex_3b = {1,1,1,0};
	 int[] ex_4b = {0,0,1,1};
	 int[] ex_5b = {0,0,1,0};
	 int ex1 = hammingDistance(ex_1a, ex_1b);
	 System.out.println("Hamming distance ex1: " + ex1);
	 int ex2 = hammingDistance(ex_1a, ex_2b);
	 System.out.println("Hamming distance ex1: " + ex2);
	 int ex3 = hammingDistance(ex_1a, ex_3b);
	 System.out.println("Hamming distance ex1: " + ex3);
	 int ex4 = hammingDistance(ex_1a, ex_4b);
	 System.out.println("Hamming distance ex1: " + ex4);
	 int ex5 = hammingDistance(ex_1a, ex_5b);
	 System.out.println("Hamming distance ex1: " + ex5);
	 
	 int[] a1 = {1,0,1,1,1,0,1};
	 int[] a2 = {1,0,0,1,1,1,1};
	 int[] a3 = {1,0,1,1,1,0,1};
	 int[] a4 = {1,1,1,0,1,0,0};
	 
	 int h1 = hammingDistance(a1, a2);
	 System.out.println("Hamming distance 3a_1: " + h1);
	 int h2 = hammingDistance(a3, a4);
	 System.out.println("Hamming distance 3a_2: " + h2);
	 
	 System.out.println("\n========= Problem 3 - Part b =========");
	 int[] c_3b = {1,0,1,1,1,0,1};
	 int[][] G1_3b = {
		 {0,1,0,1,0,0,1},
		 {1,1,0,0,1,0,0},
		 {0,0,1,0,1,0,1},
		 {0,1,0,0,1,1,1}
	 };
	 
	 /* int k_1 = 4;
	 int n_1 = 7;
	 int r_1 = 3; */
	 int[][] x_3b = generateAllMessages(k_1);
	 //printArray(x_3b);
	 
	 int[][] xG1_3b = multMatrix(x_3b, G1_3b);
	 mod2(xG1_3b);
	 //printArray(xG1_3b);
	 
	 System.out.println("Messages, x, such that hammingDistance(x,c_3b) = 1:");
	 for (int i = 0; i < xG1_3b.length; i++){
		if (hammingDistance(c_3b, xG1_3b[i]) == 1){
			printArray(xG1_3b[i]);
		}			
	 }
	 
	 System.out.println("\n========= Problem 3 - Part c =========");
	 int[] c_3c = {1,1,0,1,0,0,1,0,1,0,0,1,1,1,1};
	 int[][] G1_3c = {
		 {1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
		 {1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
		 {1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
		 {1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
		 {1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0},
		 {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
		 {0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
		 {0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0},
		 {0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
		 {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
		 {0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0}
	 };
	 
	 /* int k_2 = 11;
	 int n_2 = 15;
	 int r_2 = 4; */
	 int[][] x_3c = generateAllMessages(k_2);
	 //printArray(x_3c);
	 
	 int[][] xG1_3c = multMatrix(x_3c, G1_3c);
	 mod2(xG1_3c);
	 //printArray(xG1_3c);
	 
	 System.out.println("Messages, x, such that hammingDistance(x,c_3c) = 1:");
	 for (int i = 0; i < xG1_3c.length; i++){
		if (hammingDistance(c_3c, xG1_3c[i]) == 1){
			printArray(xG1_3c[i]);
		}			
	 }
	 
	 // Display a Goodbye note
	 System.out.println("\nGoodbye!");

 } // end method main
 
} // end class