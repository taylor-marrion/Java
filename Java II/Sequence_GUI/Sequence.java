/* Filename: Sequence.java
 * Author: Taylor Marrion
 * Date: 11/29/2019
 * Purpose: This class provides methods to compute the nth term in a sequence using iterative and recursive methods, as well as computing efficiency data for each term.
 */
 
 // Import statements
 //import java.io.IOException;

/**
* 
*/
public class Sequence {
	
	private static int result = 0;
	private static int efficiency = 0;
	
	// computes nth term of sequence using iterative algorithm
	public static int computeIterative(int n) {

		int nMinus2 = 1; // = n-1
		int nMinus1 = 2; // = n-2
		
		if (n < 3) {
			result = n;
		} else {
			for(int i = 2; i < n; i++){
			result = (2 * nMinus1) + nMinus2;
			nMinus2 = nMinus1;
			nMinus1 = result;
			efficiency++;
			} // end for loop
		} // end if-else statements
		
		return result;
	} // end computeIterative
	
	// computes nth term of sequence using recursive algorithm
	public static int computeRecursive(int n) {
		
		if (n < 3) {
			result = n;
		} else {
			result = (2 * computeRecursive(n-1)) + (computeRecursive(n-2)); // = (2*(n-1)) + (n-2)
		} // end if-else statements
		
		efficiency++;
		
		return result;
	} // end computeRecursive
	
	// returns iterations of loop or number of calls to recursive method
	public static int getEfficiency() {
		int temp = efficiency;
		efficiency = 0; // resets efficiency for next term in sequence
		
		return temp;
	} // end getEfficiency

} // end class