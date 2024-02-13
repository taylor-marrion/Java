/* Filename: findX.java
 * Author: Taylor Marrion
 * Date: March 1, 2022
 * Purpose: 
 */
 
 // Import statements
 import java.util.*;

/**
* 
*/
public class findX {
	
	static int findX(int arr[], int x) {
		if (arr.length < 2) {
			System.out.println("There's only one number...");
			if (arr[0] == x) {
				return 0;
			} else {
				System.out.println("and that's not it.");
				return -1;
			}
		} else if (arr.length == 2) {
			if (arr[0] == x) {
				System.out.println("LEFT");
				return 0;
			} else if (arr[1] == x) {
				System.out.println("RIGHT");
				return 1;
			} else {
				System.out.println("Your number is not found.");
				return -1;
			}
		} else {
			// Find sizes of two subarrays to be merged
			int m = arr.length / 2;
			int n1 = m;
			int n2 = arr.length - m;
			
			/* Create temp arrays */
			int L[] = new int[n1];
			int R[] = new int[n2];
			
			/*Copy data to temp arrays*/
			for (int i = 0; i < n1; i++) {
				L[i] = arr[i];
			}
			for (int i = 0; i < n2; i++) {
				R[i] = arr[m + i];
			}
			
			// if L contains x
			if (Arrays.stream(L).anyMatch(i->i==x)) {
				System.out.println("LEFT");
				return findX(L, x);
			} else {
				System.out.println("RIGHT");
				return findX(R, x) + L.length;
			}
		}
	} // end findX
	
	/* A utility function to print array of size n */
	static void printArray(int a[]) {
		int n = a.length;
		for (int i=0; i<n; i++) {
			System.out.print(a[i] + " ");
		} // end for-loop
		System.out.println();
	} // end printArray
	
 public static void main(String[] args) {
	 
	 // Display a Welcome note
	 System.out.println("Let's merge!");
	 
	 // Use the Scanner class to input data
	 Scanner in = new Scanner(System.in);
	 
	 // Start code
	 int[] arr1 = {1,3,7,4,2,0,6,5};
	 System.out.println("Array to search: ");
	 printArray(arr1);
	 System.out.print("Int to search for: ");
	 int x1 = in.nextInt();
	 int pos1 = findX(arr1, x1);
	 System.out.println("Index of " + x1 + ": " + pos1);
	 
	 int[] arr2 = {8,6,7,5,3,0,9,11,13,17,4,2,15,10,12,1};
	 System.out.println("Array to search: ");
	 printArray(arr2);
	 System.out.print("Int to search for: ");
	 int x2 = in.nextInt();
	 int pos2 = findX(arr2, x2);
	 System.out.println("Index of " + x2 + ": " + pos2);

 } // end method main
 
} // end class