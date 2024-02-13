/* Filename: Employee.java
 * Author: Taylor Marrion
 * Date: 11/3/2019
 * Purpose: This class creates Employee objects with name and monthly salaries.
 */

public class Employee {

    // declare fields
    private String name; // "Last,First"
    private int monthlySalary; // monthly pay in whole dollars

    // constructor
    public Employee(String name, int monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    // calculate annual salary
    public int annualSalary() {
        return (this.monthlySalary * 12); // monthly salary multiplied by 12 months
    }

    // override toString()
    @Override
    public String toString() {
        return ("Name: " + this.name + " Monthly Salary: "
                + this.monthlySalary);
    }

} // end class