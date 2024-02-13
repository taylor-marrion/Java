/* Filename: TestGuitar.java
 * Author: Taylor Marrion
 * Date: September, 14 2019
 * Purpose: Week 4 Homework. Build a program to test instances of public class Guitar
 */
 
 // Import statements
 import java.util.*;
 import java.awt.*;

/**
* 
*/
public class TestGuitar {
	
 public static void main(String[] args) {
	 
	 // create instances of Guitar
	 Guitar guitar1 = new Guitar();
	 Guitar guitar2 = new Guitar(6, 29.6, "Ibanez", Color.green);
	 Guitar guitar3 = new Guitar(7, 31.0, "ESP", Color.magenta);
	 
	 // declare array of guitars to facilitate looping
	 Guitar[] guitars = {guitar1, guitar2, guitar3};
	 
	 // print output for each guitar
	 for (int i = 0; i < guitars.length; i++) {
		 System.out.println("***Output***");
		 System.out.println("toString(): " + guitars[i].toString());
		 System.out.println("getNumStrings(): " + guitars[i].getNumStrings());
		 System.out.println("getGuitarLength(): " + guitars[i].getGuitarLength());
		 System.out.println("getGuitarManufacturer(): " + guitars[i].getGuitarManufacturer());
		 System.out.println("getGuitarColor(): "+ guitars[i].getGuitarColor());
		 System.out.println("playGuitar(): " + guitars[i].playGuitar());
		 System.out.println(""); // blank line for spacing
	 }
	 
	 System.out.println("Goodbye!");
	 
	 System.out.println(guitar1.getGuitarColor());
	 
	
 } // end method main
 
} // end class