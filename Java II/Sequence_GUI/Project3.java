/* Filename: Project3.java
 * Author: Taylor Marrion
 * Date: 11/29/2019
 * Purpose: This program constructs a GUI and allows user to enter an integer, n, in order to compute the nth term in a sequence where each term of the sequence is twice the previous term plus the second previous term. The user can select to do this using either an iterative or recursive algorithm. upon closing, the program will write effeciency data to a .csv file for future analysis.
 */
 
 // Import statements
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
/* import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent; */
import javax.swing.*;

/**
* 
*/
public class Project3 extends JFrame {
	
	// frame and text parameters
	static final int WINDOWWIDTH = 300;
	static final int WINDOWHEIGHT = 300;
	static final int TEXTWIDTH = 200;
	static final int TEXTHEIGHT = 25;
	
	// GUI component fields
	private JPanel mainPanel = new JPanel();
	private GridBagConstraints gbCon = new GridBagConstraints();
	private JRadioButton iterativeRadioButton = new JRadioButton("Iterative");
	private JRadioButton recursiveRadioButton = new JRadioButton("Recursive");
	private ButtonGroup radioButtons = new ButtonGroup();
	private JLabel nLabel = new JLabel("Enter n:");
	private JTextField nTextField = new JTextField("");
	private JLabel blankLabel = new JLabel("");
	private JButton computeButton = new JButton("Compute");
	private JLabel resultLabel = new JLabel("Result:");
	private JTextField resultTextField = new JTextField("");
	private JLabel effeciencyLabel = new JLabel("Efficiency:");
	private JTextField effeciencyTextField = new JTextField("");
	private JOptionPane newPane = new JOptionPane();
	
	/**
	* Project 3 GUI constructor
	*/
	public Project3() {
		
		// set window defaults
		setTitle("Project 3");
		setSize(WINDOWWIDTH, WINDOWHEIGHT);
		setLayout(new GridBagLayout());
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add JPanel and set layouts
		add(mainPanel);
		mainPanel.setLayout(new GridLayout(6,2,10,10));
		//gbCon.gridy = 2;
		//add(nLabel, gbCon);
		
		// add components
		mainPanel.add(iterativeRadioButton);
		mainPanel.add(recursiveRadioButton);
		mainPanel.add(nLabel);
		mainPanel.add(nTextField);
		mainPanel.add(blankLabel);
		mainPanel.add(computeButton);
		mainPanel.add(resultLabel);
		mainPanel.add(resultTextField);
		mainPanel.add(effeciencyLabel);
		mainPanel.add(effeciencyTextField);
		
		// set editable
		resultTextField.setEditable(false);
		effeciencyTextField.setEditable(false);		
		
		// add radio buttons to buttonGroup
		radioButtons.add(iterativeRadioButton);
		radioButtons.add(recursiveRadioButton);
		
		// iterative method selected by default
		iterativeRadioButton.setSelected(true);
		
		setVisible(true);
		
		/**
		* action listeners
		*/
		computeButton.addActionListener(new ComputeButtonListener());
		nTextField.addMouseListener(new NTextFieldListener());
		WindowCloseListener close = new WindowCloseListener();
		addWindowListener(close);
		
	} // end Project3 constructor
	
	/**
	* event handlers
	*/
	
	// generates output based on radio button selected and user entry of n
	class ComputeButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) throws NumberFormatException {
			try {
				int n = Integer.parseInt(nTextField.getText());
				int result = 0;
				int effeciency = 0;
				
				if (n < 0) {
					resultTextField.setText("");
					effeciencyTextField.setText("");
					JOptionPane.showMessageDialog(null, "Please enter a positive integer value.");
				} else {
					if (iterativeRadioButton.isSelected()) {
						result = Sequence.computeIterative(n);
					} else {
						result = Sequence.computeRecursive(n);
					} // end if-else statements
					effeciency = Sequence.getEfficiency();
				} // end if-else statements
				
				// set text fields
				resultTextField.setText(Integer.toString(result));
				effeciencyTextField.setText(Integer.toString(effeciency));
				
			} catch (NumberFormatException ex) {
				resultTextField.setText("");
				effeciencyTextField.setText("");
				JOptionPane.showMessageDialog(null, "Please enter a positive integer value.");
			} // end try-catch
			
		} // end actionPerformed
		
	} // end ComputeButtonListener
	
	// clears nTextField when clicked
	class NTextFieldListener extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			nTextField.setText("");
		} // end actionPerformed
		
	} // ends NTextFieldListener
	
	// writes effeciency data to file and closes GUI window
	class WindowCloseListener extends WindowAdapter {
		
		@Override
		public void windowClosing(WindowEvent e){
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			try {
				String filename = new String("effeciencyData.csv");
				FileOutputStream outputStream = new FileOutputStream(filename);
				
				// write header info to file
				String header = ("n, iterative effeciency, recursive effeciency\n");
				byte[] strToBytes = header.getBytes();
				outputStream.write(strToBytes);
				
				String line;
				
				// write data for each n to file
				for(int i = 0; i <= 10; i++){
					
					int x = Sequence.computeIterative(i);
					int iterativeEfficiency = Sequence.getEfficiency();
					int y = Sequence.computeRecursive(i);
					int recursiveEfficiency = Sequence.getEfficiency();
					
					line = ((i) + "," + (iterativeEfficiency) + "," + (recursiveEfficiency) + "\n");
					strToBytes = line.getBytes();
					outputStream.write(strToBytes);
				} // end for loop
				
				outputStream.close(); // close FileOutputStream
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error! Unable to write to specified file.");
			} finally {
				System.exit(0); // exit program
			} // end try-catch-finally
			
		} // end windowClosing
		
	} // end WindowCloseListener
	
	public static void main(String[] args) {
		
		// create Project3 class object
		Project3 Project3_GUI = new Project3();
		
	} // end method main
 
} // end class