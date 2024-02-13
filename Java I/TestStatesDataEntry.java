/* FileName: TestStatesDataEntry.java
 * Author: Taylor Marrion
 * Date: 10/4/2019
 * Purpose: This program tests the StateBirdFlower class. This program will prompt the user to enter a state, then display that state bird and flower. The prgram will run until the user enters "None", followed by a summary of the results.
 */

package StatesDataEntry;

// import classes
import java.util.*;

public class TestStatesDataEntry {
    
    public static void main(String[] args) {
        
        // initialize Scanner class to collect input data
        Scanner in = new Scanner(System.in);
         
        // get states from user
        StatesDataEntry.enterStates(in);
        
        System.out.println(); // used for spacing
        
        // summary of states
        StatesDataEntry.printSummary();

    } // end main method

} // end class
