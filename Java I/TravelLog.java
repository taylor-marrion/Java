/* Filename: TravelLog.java
 * Author: Taylor Marrion
 * Date: September 12, 2019
 * Purpose: Week 4 discussion. Class used to create and edit a travel log.
 */

/**
* 
*/
public class TravelLog {
	
	// Declare fields
	private String licensePlate;
	private double startMileage;
	private double currentMileage;
	private double legMileage; // tracks mileage between oil changes
	private double oilChangeMileage = 3000.0; // recommended mileage between oil changes
	
	// constructor
	public TravelLog (String licensePlate, double startMileage, double currentMileage, double legMileage) {
		this.licensePlate = licensePlate;
		this.startMileage = startMileage;
		this.currentMileage = currentMileage;
		this.legMileage = legMileage;
	} // end constructor
	
	// default constructor
	public TravelLog() {
		this.licensePlate = "(License plate missing)";
		this.startMileage = 0.0;
		this.currentMileage = 0.0;
		this.legMileage = 0.0;
	} // end default constructor
	
	
	// setter methods
	
	// set license plate
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	// add miles
	public void addMiles(double newMiles) {
		this.currentMileage += newMiles;
		this.legMileage += newMiles;
	}
	
	// reset leg
	public void resetLegMileage() {
		this.legMileage = 0.0;
	}
	
	// getter methods
	
	// get license plate
	public String getLicensePlate() {
		return this.licensePlate;
	}
	
	// get current mileage
	public double getCurrentMileage() {
		return this.currentMileage;
	}
	
	// get leg mileage
	public double getLegMileage() {
		return this.legMileage;
	}
	
	// get oil change status
	public void checkStatus() {
		System.out.println("*** Travel details of " + this.licensePlate + " ***");
		System.out.println("Trip mileage: " + (currentMileage - startMileage));
		System.out.println("Current leg: " + legMileage);
		if (legMileage >= oilChangeMileage) {
			System.out.println("You need an oil change!");
		} else {
			System.out.println("You will need an oil change in " + (oilChangeMileage - legMileage) + " miles.");
		}
	}
	
	// create new travel log instance and call methods
 
} // end class