/* Filename: Guitar.java
 * Author: Taylor Marrion
 * Date: September, 14 2019
 * Purpose: Week 4 Homework. Build a class to create instances of Guitar
 */
 
 // Import statements
 import java.util.*;
 import java.awt.*;

/**
* 
*/
public class Guitar {
	
	// Declare fields
	private int numStrings; // number of strings on the guitar
	private double guitarLength; // length of the guitar in inches
	private String guitarManufacturer; // manufacturer of the guitar
	private Color guitarColor; // color of the guitar
	
	// no argument constructor
	public Guitar() {
	this.numStrings = 6;
	this.guitarLength = 28.2;
	this.guitarManufacturer = "Gibson";
	this.guitarColor = Color.red;
	} // end of no argument constructor
	
	// constructor
	public Guitar(int numStrings, double guitarLength, String guitarManufacturer, Color guitarColor){
		this.numStrings = numStrings;
		this.guitarLength = guitarLength;
		this.guitarManufacturer = guitarManufacturer;
		this.guitarColor = guitarColor;
	} // end of constructor
	
	// getter methods
	// get number of strings
	public int getNumStrings() {
		return this.numStrings;
	}
	// get length of guitar
	public double getGuitarLength() {
		return this.guitarLength;
	}
	// get manufacturer of guitar
	public String getGuitarManufacturer() {
		return this.guitarManufacturer;
	}
	// get color of guitar
	public Color getGuitarColor() {
		return this.guitarColor;
	}
	
	// play 16 random notes
	public String playGuitar() {
		
		// create new random object
		Random randomNote = new Random();
		
		final int NUMNOTES = 16; // number of random notes to generate
		
		// declare and initialize arrays of notes and durations
		final String[] NOTES = {"A","B","C","D","E","F","G"};
		final String[] TIMES = {".25",".5","1","2","4"};
		
		// initilize empty string
		String str = "";
		
		// generate random notes and lengths
		for (int i = 0; i < NUMNOTES; i++) {
			int note = randomNote.nextInt(NOTES.length);
			int time = randomNote.nextInt(TIMES.length);
			str += NOTES[note] + "(" + TIMES[time] + "),"; // add notes to String
		}
		
		str = str.substring(0,(str.length()-1)); // remove last comma
		
		str = "[" + str + "]"; // add brackets to notes
		
		return str;
	} // end of playGuitar
	
	// to string
	public String toString() {
		String str = "(numStrings=" + this.numStrings + ", Length=" + this.guitarLength + ", manufacturer=" + this.guitarManufacturer + ", color=" + this.guitarColor + ")";
		
		return str;
	}
 
 
} // end class