/* FileName: Week7Discussion.java
 * Author: Taylor Marrion
 * Date: 10/2/2019
 * Purpose: This program uses command line input to generate x random integers between 0 and y.
 */
 
// import classes
import java.util.*;

public class Week7Discussion {

    public static void main(String[] args) {        
        
        // Variables to hold values
        int x = Integer.parseInt(args[0]); // number of random ints to generate
        int y = Integer.parseInt(args[1]); // ceiling of random ints
        Random randomInt = new Random();
		
		// dispay welcome note
        System.out.println("Hello! Let's generate " + x + " random integers, with a ceiling of " + y + ".");
        
        // for loop to generate and print random ints
        for (int i = 0; i<x; i++){
            System.out.println(randomInt.nextInt(y));
        } // end for loop
        
    } // end method main
    
} // end class