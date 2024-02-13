/* Filename: Salesman.java
 * Author: Taylor Marrion
 * Date: 11/3/2019
 * Purpose: This class extends Employee, adds annualSales instance variable, overrides annualSalary method, and overrides toString method.
 */

public class Salesman extends Employee {

    // declare fields
    private int annualSales; // annual sales in whole dollars

    // constructor
    public Salesman(String name, int monthlySalary, int annualSales) {
        super(name, monthlySalary);
        this.annualSales = annualSales;
    }

    // override annualSalary from superclass Employee to include commission
    @Override
    public int annualSalary() {
        int commission = (this.annualSales / 50); // commission equals 2% of annual sales by salesman

        // maximum commission is $20,000
        if (commission > 20000) {
            commission = 20000;
        } // end if statement

        return (super.annualSalary() + commission);
    }

    // overrides toString from superclass Employee to include annual sales
    @Override
    public String toString() {
        String str = (super.toString() + " Annual Sales: " + this.annualSales);
        return str;
    }

} // end class