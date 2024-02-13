/* Filename: Project4_GUI.java
 * Author: Taylor Marrion
 * Date: 12/14/2019
 * Purpose: This program constructs a GUI and allows users to insert, delete, find, and update a HashMap database of Student class objects.
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
public class Project4_GUI extends JFrame {
	
	// frame and text parameters
	static final int WINDOWWIDTH = 300;
	static final int WINDOWHEIGHT = 300;
	static final int TEXTWIDTH = 200;
	static final int TEXTHEIGHT = 25;
	
	// GUI main component fields
	private JPanel mainPanel = new JPanel();
	private GridBagConstraints gbCon = new GridBagConstraints();
	private JLabel idLabel = new JLabel("ID:");
	private JTextField idTextField = new JTextField("");
	private JLabel nameLabel = new JLabel("Name:");
	private JTextField nameTextField = new JTextField("");
	private JLabel majorLabel = new JLabel("Major:");
	private JTextField majorTextField = new JTextField("");
	private JLabel chooseLabel = new JLabel("Choose Selection:");
	private String[] actionOptions = {"Insert", "Delete", "Find", "Update"};
	private JComboBox<String> actionCombo = new JComboBox<>(actionOptions);
	private JButton processButton = new JButton("Process Request");
	private JButton clearButton = new JButton("Clear all fields");
	private JOptionPane newPane = new JOptionPane();
	
	// grade pane component fields
	private String[] gradesOptions = {"A", "B", "C", "D", "F"};
	private JComboBox<String> gradesCombo = new JComboBox<>(gradesOptions);
	
	// credits pane component fields
	private String[] creditsOptions = {"3", "6"};
	private JComboBox<String> creditsCombo = new JComboBox<>(creditsOptions);
	
	// create HashMap of Student class objects
	HashMap<String, Student> studentDB = new HashMap<String, Student>();
	
	/**
	* Project 4 GUI constructor
	*/
	public Project4_GUI() {
		
		// set window defaults
		setTitle("Project 4");
		setSize(WINDOWWIDTH, WINDOWHEIGHT);
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add JPanel and set layouts
		add(mainPanel);
		mainPanel.setLayout(new GridLayout(5,2,10,10));
		
		// add components
		mainPanel.add(idLabel);
		mainPanel.add(idTextField);
		mainPanel.add(nameLabel);
		mainPanel.add(nameTextField);
		mainPanel.add(majorLabel);
		mainPanel.add(majorTextField);
		mainPanel.add(chooseLabel);
		mainPanel.add(actionCombo);
		mainPanel.add(processButton);
		mainPanel.add(clearButton);
		
		// set editable
		idTextField.setEditable(true);
		nameTextField.setEditable(true);
		majorTextField.setEditable(true);
		actionCombo.setEditable(false);
		gradesCombo.setEditable(false);
		creditsCombo.setEditable(false);
		
		setVisible(true);
		
		/**
		* action listeners
		*/
		processButton.addActionListener(new ProcessButtonListener());
		clearButton.addActionListener(new ClearButtonListener());
		
	} // end Project4_GUI constructor
	
	/**
	* event handlers
	*/
	// 
	class ProcessButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// check if user entered ID. Checking here prevents repeated code and futile method calls.
			String id = idTextField.getText();
			if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "No ID entered. Please enter a valid ID to continue.", "Missing data", JOptionPane.ERROR_MESSAGE);
			} else {
				String action = actionCombo.getSelectedItem().toString();
				switch (action) {
					case "Insert":
						insert(id);
						break;
					case "Delete":
						delete(id);
						break;
					case "Find":
						find(id);
						break;
					case "Update":
						update(id);
						break;
				} // end switch
			} // end if-else statement
		} // end actionPerformed
	} // end ProcessButtonListener
	
	// allows user to clear all data fields with single click
	class ClearButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			clearAllTextFields();
		} // end actionPerformed
	} // end ClearButtonListener
	
	
	/**
	* methods
	*/
	public void insert(String id) {
		String name = nameTextField.getText();
		String major = majorTextField.getText();
		
		if (studentDB.containsKey(id)) {
			// check for duplicate entries
			JOptionPane.showMessageDialog(null, "ID already in use. Please enter a valid new ID to continue.", "Insert failed", JOptionPane.ERROR_MESSAGE);
		} else if (name.equals("") || major.equals("")) {
			// check all data is entered
			JOptionPane.showMessageDialog(null, "At least one field left blank. Please enter name and major to continue.", "Insert failed", JOptionPane.ERROR_MESSAGE);
		} else {
			Student student = new Student(name, major);
			studentDB.put(id, student);
			JOptionPane.showMessageDialog(null, "Student successfully added to database!", "Insert succeeded", JOptionPane.INFORMATION_MESSAGE);
		} // end if-else statements
		
	} // end insert method
	
	public void delete(String id) {
		if (studentDB.containsKey(id)) {
			// ID is found
			studentDB.remove(id);
			JOptionPane.showMessageDialog(null, "Student successfully deleted from database!", "Delete succeeded", JOptionPane.INFORMATION_MESSAGE);
		} else {
			// ID is not found
			missingID();
		} // end if-else statements
		
	} // end delete method
	
	public void find(String id) {
		if (studentDB.containsKey(id)) {
			// ID is found
			Student student = studentDB.get(id);
			String info = student.toString();
			JOptionPane.showMessageDialog(null, info, "Find succeeded", JOptionPane.INFORMATION_MESSAGE);
		} else {
			// ID is not found
			missingID();
		} // end if-else statements
	
	} // end find method
	
	public void update(String id) {
		if (studentDB.containsKey(id)) {
			// ID is found
			JOptionPane.showMessageDialog(null, new Object[]{"Choose grade:", gradesCombo}, "", JOptionPane.QUESTION_MESSAGE);
			String letterGrade = gradesCombo.getSelectedItem().toString();
			JOptionPane.showMessageDialog(null, new Object[]{"Choose credits:", creditsCombo}, "", JOptionPane.QUESTION_MESSAGE);
			double credits = Double.parseDouble(creditsCombo.getSelectedItem().toString());
			
			Student student = studentDB.get(id);
			student.courseCompleted(letterGrade, credits);
			
			JOptionPane.showMessageDialog(null, "Student profile successfully updated!", "Update succeeded", JOptionPane.INFORMATION_MESSAGE);
		} else {
			// ID is not found
			missingID();
		} // end if-else statements
		
	} // end update method
	
	// clears all text fields
	public void clearAllTextFields() {
		idTextField.setText("");
		nameTextField.setText("");
		majorTextField.setText("");
	} // end clearAllTextFields
	
	// error message displayed when user tries to delete, find, or update an ID not in the HashMap database
	public void missingID() {
		JOptionPane.showMessageDialog(null, "ID not found. Please enter a valid existing ID to continue.", "Request failed", JOptionPane.ERROR_MESSAGE);
	} // end missingID method
	

/**
* main method
*/
 public static void main(String[] args) {
	 
	 // Start GUI
	 Project4_GUI GUI = new Project4_GUI();
	
 } // end method main
 
} // end Project4_GUI class