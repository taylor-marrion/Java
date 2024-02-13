/* Filename: TestTravelLog.java
 * Author: Taylor Marrion
 * Date: September 12, 2019
 * Purpose: Week 4 discussion. This program constructs instances of the TravelLog class.
 */

/**
* 
*/
public class TestTravelLog {
	
 public static void main(String[] args) {
	 
	 // Display a Welcome note
	 System.out.println("Welcome to my travel log program!");
	 System.out.println();
	 
	 // create new travel logs
	 TravelLog log0 = new TravelLog(); // no argument instance of TravelLog class
	 TravelLog log1 = new TravelLog("D0C-BRWN",1985.0,2015.0,8.8); // Doc Brown and Marty's road trip
	 TravelLog log2 = new TravelLog("GRSWLD",86000.6,87654.3,3105.4); // Clark's family vacation to Wally World
	 
	 // initial status of travel logs
	 log0.checkStatus();
	 System.out.println(); // just used for spacing
	 log1.checkStatus();
	 System.out.println();
	 log2.checkStatus();
	 System.out.println();
	 
	 // test methods
	 
	 // set a license plate
	 log0.setLicensePlate("CAR-054");
	 System.out.println("The first car's license plate has been set to " + log0.getLicensePlate());
	 
	 // add mileage
	 log0.addMiles(3109.3);
	 System.out.println(log0.getLicensePlate() + "'s odometer now reads " + log0.getCurrentMileage());
	 System.out.println("This leg of the trip is now " + log0.getLegMileage() + " miles long.");
	 
	 // get oil change
	 log0.resetLegMileage();
	 log0.addMiles(54.0);
	 System.out.println(log0.getLicensePlate() + " got an oil change and drove 54 miles.");
	 System.out.println();
	 
	 // check final status of car
	 log0.checkStatus();
	 
 } // end method main
 
} // end class