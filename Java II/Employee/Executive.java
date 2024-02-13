/* Filename: Executive.java
 * Author: Taylor Marrion
 * Date: 11/3/2019
 * Purpose: This class extends Employee, adds stockPrice instance variable, overrides annualSalary method, and overrides toString method.
 */

public class Executive extends Employee {

    // declare fields
    private int stockPrice; // stock price in whole dollars

    // constructor
    public Executive(String name, int monthlySalary, int stockPrice) {
        super(name, monthlySalary);
        this.stockPrice = stockPrice;
    }

    // override annualSalary from superclass Employee to include possible bonus
    @Override
    public int annualSalary() {
        int bonus = 0;

        if (this.stockPrice > 50) {
            bonus += 30000;
        }

        return (super.annualSalary() + bonus);
    }

    // overrides toString from superclass Employee to include annual sales
    @Override
    public String toString() {
        String str = (super.toString() + " Stock Price: " + this.stockPrice);
        return str;
    }

} // end class