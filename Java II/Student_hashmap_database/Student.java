/* Filename: Student.java
 * Author: Taylor Marrion
 * Date: 12/14/2019
 * Purpose: This class constructs and modifies Student objects with ID, name, major, and GPA attributes.
 */
 
 // Import statements
 import java.text.DecimalFormat;

/**
* 
*/
public class Student {
	
	private String name;
	private String major;
	private double creditsCompleted;
	private double qualityPoints;
	private double gpa = 4.0;
	private int gradePoints;
	private static DecimalFormat decFormat = new DecimalFormat("#0.00");
	
	// constructor
	public Student(String name, String major){
		this.name = name;
		this.major = major;
		this.creditsCompleted = 0.0;
		this.qualityPoints = 0.0;
	} // end constructor
	
	public void courseCompleted(String letterGrade, double credits) {
		double gradePoints = 0.00;
		switch (letterGrade) {
			case "A":
				gradePoints = 4.00;
				break;
			case "B":
				gradePoints = 3.00;
				break;
			case "C":
				gradePoints = 2.00;
				break;
			case "D":
				gradePoints = 1.00;
				break;
			case "F":
				gradePoints = 0.00;
				break;
		} // end switch
		
		this.creditsCompleted += credits; // update total credits completed
		this.qualityPoints += (credits * gradePoints); // update total quality points
		
		this.gpa = (qualityPoints / creditsCompleted); // updates GPA
		
	} // end courseCompleted method
	
	@Override
	public String toString() {
		return String.format("Name: %s;   Major: %s;   GPA: %.2f", this.name, this.major, this.gpa);
		
	} // end toString method
 
} // end Student class