/*
 * FileName: HeadPhone.java
 * Author: Taylor Marrion
 * Date: 9/28/2019
 * Purpose: HeadPhone class
 */
package headphone;

// Import statements
 import java.awt.*;

/**
 *
 * @author Teebs
 */
public class HeadPhone {
    
    // declare fields
    // class fields
    private static final int MUTE = 0; // headphones muted
    private static final int LOW = 1;
    private static final int MEDIUM = 2;
    private static final int HIGH = 3;
    // instance fields
    private int volume; // stores int value of volume
    private boolean pluggedIn; // determines if headphone is plugged in
    private String manufacturer; // stores manufacturer of headphones
    private Color headPhoneColor; // stores color of headphones
    private String headPhoneModel; // stores model of headphones
    
    // no argument constructor
    public HeadPhone() {
        this.volume = MEDIUM;
        this.pluggedIn = false;
        this.manufacturer = "unknown";
        this.headPhoneColor = Color.black; // black was arbitrarily chosen as default color
        this.headPhoneModel = "unknown";
    } // end of no argument constructor
    
//    // constructor
//    public HeadPhone(int volume, boolean pluggedIn, String manufacturer, Color headPhoneColor, String headPhoneModel){
//        this.volume = volume;
//        this.pluggedIn = pluggedIn;
//        this.manufacturer = manufacturer;
//        this.headPhoneColor = headPhoneColor;
//        this.headPhoneModel = headPhoneModel;
//    } // end of constructor method
    // constructor w/ arguments not asked for in assignment
    
    // getter methods
    // get volume
    public String getVolume(){
        String strVolume;
        switch (this.volume) {
            case 0:
                strVolume = "MUTE";
                break;
            case LOW:
                strVolume = "LOW";
                break;
            case HIGH:
                strVolume = "HIGH";
                break;
            default:
                strVolume = "MEDIUM";
                break;
        }
        return strVolume;
    } // end of getVolume
    
    // get plugged in
    public boolean getPluggedIn(){
        return this.pluggedIn;
    } // end of getPluggedIn
    
    // get manufacturer
    public String getManufacturer(){
        return this.manufacturer;
    } // end of getManufacturer
    
    // get color
    public Color getHeadPhoneColor(){
        return this.headPhoneColor;
    } // end of getColor
    
    // get model
    public String getHeadPhoneModel(){
        return this.headPhoneModel;
    }
    
    // setter methods
    // set volume
    public void setVolume(int volume){
        if (volume<MUTE || volume >HIGH){
            System.out.println("Volume out of range (" + MUTE + "-" + HIGH + ").");
        } else{
            this.volume = volume;
        }
    } // end of setVolume
    
    // set plugged in
    public void setPluggedIn(boolean pluggedIn){
        this.pluggedIn = pluggedIn;
    } // end of setPluggedIn
    
    // set manufacturer
    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    } // end setManufacturer
    
    // set color
    public void setHeadPhoneColor(Color color){
        this.headPhoneColor = color;
    } // end setHeadPhoneColor
    
    // set model
    public void setHeadPhoneModel(String model){
        this.headPhoneModel = model;
    } // end setHeadPhoneModel
    
    // toString() method
    public String toString(){
        String volStr = "Volume: " + this.volume + "\n";
        
        String pluggedStr;
        if (pluggedIn){
            pluggedStr = "The headphones are plugged in.\n";
        } else{
            pluggedStr = "The headphones are not plugged in.\n";
        } // end if-else statement
        
        String mfgStr = "Manufacturer: " + this.manufacturer + "\n";
        String colorStr = "Color: " + this.headPhoneColor + "\n";
        String modelStr = "Model: " + this.headPhoneModel + "\n";
        return (volStr + pluggedStr + mfgStr + colorStr + modelStr);
    } // end of toString
    
    // changeVolume(value) method
    public void changeVolume(int volume){
        String[] settings = {"MUTE","LOW","MEDIUM","HIGH"};
        
        if (volume<MUTE || volume>HIGH){
            System.out.println("Volume out of range (" + MUTE + "-" + HIGH + ").");
        } else{
            this.volume = volume;
            System.out.println("Volume is now set to: " + settings[volume]);
        }
    }
    
} // end class
