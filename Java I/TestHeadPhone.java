/*
 * FileName: TestHeadPhone.java
 * Author: Taylor Marrion
 * Date: 9/28/2019
 * Purpose: Create instances and test methods of HeadPhone class
 */
package headphone;

 // Import statements
 import java.awt.*;

/**
 *
 * @author Teebs
 */
public class TestHeadPhone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create instances of HeadPhone
        HeadPhone headPhone1 = new HeadPhone();
        HeadPhone headPhone2 = new HeadPhone();
        HeadPhone headPhone3 = new HeadPhone();
        
        // declare array of headphones to facilitate looping
        HeadPhone[] headPhones = {headPhone1,headPhone2,headPhone3};
        
        // print initial values of headPhones
        System.out.println("*** Initial values for headPhones ***");
        for(int i=0; i<headPhones.length; i++){
            System.out.println("HeadPhone " + (i+1) + ":");
            System.out.println(headPhones[i].toString());
        }
        
        // implement methods
        
        // set headPhone1
        headPhone1.setVolume(0);
        headPhone1.setPluggedIn(true);
        headPhone1.setManufacturer("Sony");
        headPhone1.setHeadPhoneColor(Color.blue);
        headPhone1.setHeadPhoneModel("Sport");
        //
        System.out.println("new output for headPhone1: ");
        System.out.println("Volume: " + headPhone1.getVolume());
        System.out.println("Plugged in: " + headPhone1.getPluggedIn());
        System.out.println("Manufacturer: " + headPhone1.getManufacturer());
        System.out.println("Color: " + headPhone1.getHeadPhoneColor());
        System.out.println("Model: " + headPhone1.getHeadPhoneModel());
        
        System.out.println(); // used for spacing
        
        // headphone2
        headPhone2.setVolume(5);
        headPhone2.setVolume(3);
        headPhone2.setPluggedIn(true);
        headPhone2.setManufacturer("LG");
        headPhone2.setHeadPhoneColor(Color.red);
        headPhone2.setHeadPhoneModel("Over ear");
        //
        System.out.println("new output for headPhone2: ");
        System.out.println("Volume: " + headPhone2.getVolume());
        System.out.println("Plugged in: " + headPhone2.getPluggedIn());
        System.out.println("Manufacturer: " + headPhone2.getManufacturer());
        System.out.println("Color: " + headPhone2.getHeadPhoneColor());
        System.out.println("Model: " + headPhone2.getHeadPhoneModel());
        
        System.out.println(); // used for spacing
        
        // headphone3
        headPhone3.changeVolume(5);
        headPhone3.changeVolume(1);
        headPhone3.setPluggedIn(true);
        headPhone3.setManufacturer("LG");
        headPhone3.setHeadPhoneColor(Color.red);
        headPhone3.setHeadPhoneModel("Over ear");
        //
        System.out.println("new output for headPhone3: ");
        System.out.println("Volume: " + headPhone3.getVolume());
        System.out.println("Plugged in: " + headPhone3.getPluggedIn());
        System.out.println("Manufacturer: " + headPhone3.getManufacturer());
        System.out.println("Color: " + headPhone3.getHeadPhoneColor());
        System.out.println("Model: " + headPhone3.getHeadPhoneModel());
        
        System.out.println();
        System.out.println("Goodbye!");
        
    } // end method main
    
} // end class
