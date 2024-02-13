/* Filename: MergeSort.java
 * Author: Taylor Marrion
 * Date: March 1, 2022
 * Purpose: 
 */
 
 // Import statements
 import java.util.Random;

/**
* 
*/
public class MergeSort {
	
	// Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
	static void merge(int arr[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
		
	} // end merge
	
	// Main function that sorts arr[l..r] using
    // merge()
	static void mergeSort(int arr[], int l, int r) {
		if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
		
	} // end mergeSort
	
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
	 
	 // Start code
	 int[] arr = {7,4,2,1,3,3,7,11,8,6,7,5,3,0,9,12};
	 System.out.println("Unsorted array: ");
	 printArray(arr);
	 
	 System.out.println("Sorted array: ");
	 mergeSort(arr, 0, arr.length-1);
	 printArray(arr);
	 
	 Random rd = new Random();
	 int[] randArr = new int[100];
	 for (int i=0; i< randArr.length; i++){
		 randArr[i] = rd.nextInt(101);
	 }
	 System.out.println("Random array: ");
	 printArray(randArr);
	 System.out.println("Sorted array: ");
	 mergeSort(randArr, 0, randArr.length-1);
	 printArray(randArr);

 } // end method main
 
} // end class