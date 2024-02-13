/*
 * FileName: ATM_GUI.java
 * Author: Taylor Marrion
 * Date: 11/15/2019
 * Purpose: This class cretaes a GUI for an ATM Machine. This class was created using NetBeans JFrame Form creator.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.text.DecimalFormat;

public class ATM_GUI extends JFrame {
	
	// frame and text parameters
	static final int WINDOWWIDTH = 400;
	static final int WINDOWHEIGHT = 200;
	static final int TEXTWIDTH = 250;
	static final int TEXTHEIGHT = 25;
	
	// GUI component fields
	private JPanel buttonPanel = new JPanel();
	private JPanel textEntry = new JPanel();
	private GridBagConstraints gbCon = new GridBagConstraints();
	private JButton withdrawButton = new JButton("Withdraw");
	private JButton depositButton = new JButton("Deposit");
	private JButton transferToButton = new JButton("Transfer to");
	private JButton balanceButton = new JButton("Balance");
	private JRadioButton checkingRadio = new JRadioButton("Checking");
	private JRadioButton savingsRadio = new JRadioButton("Savings");
	private ButtonGroup radioButtons = new ButtonGroup();
	private JTextField amountField = new JTextField("");
	private static DecimalFormat decFormat = new DecimalFormat("$0.00");
	private JOptionPane newPane = new JOptionPane();
	
	// Account object fields
	private static Account checking = new Account("Checking");
	private static Account savings = new Account("Savings");
	private static Account activeAccount = checking; // GUI selects checking radio button by default, so program defaults to checking account
	private static Account otherAccount = savings;
	
	/**
	* ATM_GUI class object constructor
	*/
	public ATM_GUI() {
		
		// set defaults to GUI window
		setTitle("ATM Machine");
		setSize(WINDOWWIDTH, WINDOWHEIGHT);
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add components and set layouts
		add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));
		gbCon.gridy = 2;
		add(textEntry, gbCon);
		textEntry.add(amountField);
		amountField.setLayout(new GridLayout(1, 1));
		amountField.setPreferredSize(new Dimension(TEXTWIDTH, TEXTHEIGHT));
		
		// add buttons
		buttonPanel.add(withdrawButton);
		buttonPanel.add(depositButton);
		buttonPanel.add(transferToButton);
		buttonPanel.add(balanceButton);
		
		// add buttons to ButtonGroup so only one can be selected at a time
		radioButtons.add(checkingRadio);
		radioButtons.add(savingsRadio);
		
		// add radioButtons
		buttonPanel.add(checkingRadio);
		buttonPanel.add(savingsRadio);
		
		// checking account selected by default
		checkingRadio.setSelected(true); 
				
		setVisible(true);
		
		/**
		* action listeners
		*/ 
		withdrawButton.addActionListener(new WithdrawButtonListener());
		depositButton.addActionListener(new DepositButtonListener());
		transferToButton.addActionListener(new TransferToButtonListener());
		balanceButton.addActionListener(new BalanceButtonListener());
		checkingRadio.addActionListener(new RadioButtonListener());
		savingsRadio.addActionListener(new RadioButtonListener());
		
	} // end ATM_GUI constructor
	
	/**
	* event handlers
	*/
	
	// 
	class WithdrawButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) throws NumberFormatException {
			try {
				double amount = getEntryValue();
				double balance = activeAccount.getBalance();
				if(amount % 20 == 0 && amount > 0 && balance > amount) {
					activeAccount.withdraw(amount);
					JOptionPane.showMessageDialog(newPane, decFormat.format(amount) + " withdrawn from " + activeAccount.getName() + " account.");
				} else if (balance < amount) {
					throw new InsufficientFunds();
				} else {
					JOptionPane.showMessageDialog(newPane, "Please select an increment of $20.00");
				}
			} catch (InsufficientFunds insufficientFunds) {
	
			} // end try-catch
			
			clearTextField();
			
		} // end actionPerformed
	} // end WithdrawButtonListener class
	
	// 
	class DepositButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) throws NumberFormatException {
			double amount = getEntryValue();
			if (amount > 0) {
				activeAccount.deposit(amount);
				JOptionPane.showMessageDialog(newPane, decFormat.format(amount) + " deposited to " + activeAccount.getName() + " account.");
			} // else
				
			clearTextField();
		
		} // end actionPerformed
	} // end DepositButtonListener class
	
	// 
	class TransferToButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) throws NumberFormatException {
			
			try {
				double amount = getEntryValue();
				if (amount > 0) {
					activeAccount.transferTo(amount, otherAccount);
					JOptionPane.showMessageDialog(newPane, decFormat.format(amount) + " transferred to " + otherAccount.getName() + ".");
				}
								
			} catch (InsufficientFunds insufficientFunds) {
				
			} // end try-catch
			
			clearTextField();
			
		} // end actionPerformed
	} // end TransferToButtonListener class
	
	// 
	class BalanceButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) throws NumberFormatException {
			
			double balance = activeAccount.getBalance();
			JOptionPane.showMessageDialog(newPane, "The balance of " + activeAccount.getName() + " is " + decFormat.format(balance));
			
			clearTextField();
			
		} // end actionPerformed
	} // end BalanceButtonListener
	
	// 
	class RadioButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			selectAccount();
		} // end actionPerformed
	} // end RadioButtonListener
	
	/**
	* methods
	*/
	
	// attempts to convert text entry to a double
	public double getEntryValue() {
		double x = 0;
		try {
			x = Double.parseDouble(amountField.getText());
		} catch (NumberFormatException event) {
			
		} // end try-catch
		clearTextField();
		
		return x;
	} // end getEntryValue method
	
	// clears text entry field in GUI
	public void clearTextField() {
		amountField.setText("");
	} // end clearTextField method
	
	// determines which bank account is being acted on
	public void selectAccount() {
		if(checkingRadio.isSelected()) {
			activeAccount = checking;
			otherAccount = savings;
		} else {
			activeAccount = savings;
			otherAccount = checking;
		} //end if-else statement
	} // end selectAccount method
	
	/**
	* main method
	*/
	public static void main(String [] args) {
		
		// Creates ATM_GUI class object
		ATM_GUI ATM_Machine = new ATM_GUI();
		
	} // end main method

} // end class