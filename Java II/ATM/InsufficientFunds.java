/*
 * FileName: InsufficientFunds.java
 * Author: Taylor Marrion
 * Date: 11/15/2019
 * Purpose: This class is a user defined checked exception that is thrown when an account balance is not enough to perform the requested action.
 */

import javax.swing.*;

public class InsufficientFunds extends Exception {
    
    public InsufficientFunds(){
		JOptionPane errorFrame = new JOptionPane();
		String errorStr = new String("Insufficient Funds. Please check your balance.");
		JOptionPane.showMessageDialog(errorFrame, errorStr);
    } // end InsufficientFunds exception

} // end class
