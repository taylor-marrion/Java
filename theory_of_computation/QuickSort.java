/* Filename: QuickSort.java
 * Author: Taylor Marrion
 * Date: March 1, 2022
 * Purpose: 
 */
 
 // Import statements
 import java.util.Random;

/**
* 
*/
public class QuickSort {
	
	/* This function takes last element as pivot, places
   the pivot element at its correct position in sorted
   array, and places all smaller (smaller than pivot)
   to left of pivot and all greater elements to right
   of pivot */
	static int partition(int[] arr, int low, int high) {
     
		// pivot
		int pivot = arr[high];
     
		// Index of smaller element and
		// indicates the right position
		// of pivot found so far
		int i = (low - 1);
 
		for(int j = low; j <= high - 1; j++) {
         
			// If current element is smaller
			// than the pivot
			if (arr[j] < pivot) {
             
				// Increment index of
				// smaller element
				i++;
				swap(arr, i, j);
			}
		}
    
		swap(arr, i + 1, high);
		return (i + 1);
	}
 
	/* The main function that implements QuickSort
          arr[] --> Array to be sorted,
          low --> Starting index,
          high --> Ending index
	*/
	static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
         
        // pi is partitioning index, arr[p]
        // is now at right place
        int pi = partition(arr, low, high);
 
        // Separately sort elements before
        // partition and after partition
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
		}
	}
	
	// A utility function to swap two elements
	static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
	}
	
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
	 quickSort(arr, 0, arr.length-1);
	 printArray(arr);
	 
	 Random rd = new Random();
	 int[] randArr = new int[100];
	 for (int i=0; i< randArr.length; i++){
		 randArr[i] = rd.nextInt(101);
	 }
	 System.out.println("Random array: ");
	 printArray(randArr);
	 System.out.println("Sorted array: ");
	 quickSort(randArr, 0, randArr.length-1);
	 printArray(randArr);

 } // end method main
 
} // end class