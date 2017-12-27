/**
 * This class represents a Color Object that can be described in 
 * three different ways: by its name, hexadecimal value, or RGB value. 
 * 
 * @author Olga Zhurakivska
 * @version 09/20/2017
 * 
 * 
 */

package project1;

import java.util.Arrays;
import java.util.List; 

public class Color implements Comparable<Color>{
	
	String colorHexValue, colorName; 
	int red, green, blue; 
	String [] values = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "A", "B", "C", "D", "E", "F"};
	List <String> validHexValues = Arrays.asList(values); 
	boolean passPrimaryValidityTest, passSecondaryValidityTest, passLengthTest; 
	int secondaryValidityTestCounter; 

	public Color (String colorHexValue) {
		
		// Test1: check that the first character is "#"
		if (Character.toString(colorHexValue.charAt(0)).equals("#")) {
			passPrimaryValidityTest = true; 
		}
		
		// Test2: check that all of the characters in colorHexValue following "#" are valid 
		for (int i = 1; i < colorHexValue.length(); i++){
			if (validHexValues.contains(Character.toString(colorHexValue.charAt(i)))){
				secondaryValidityTestCounter++;  
			} 
		}
		if (secondaryValidityTestCounter == 6) {
			passSecondaryValidityTest = true; 
		}
		
		// Test3: check that the string has the correct length 
		if (colorHexValue.length() == 7) {
			passLengthTest = true; 
		}
		
		// check that the entered argument meets all the criteria
		// if it doesn't meet one or more criteria, display a specific error message
		if (passLengthTest == true &&
			passPrimaryValidityTest == true &&
			passSecondaryValidityTest == true) {
			this.colorHexValue = colorHexValue; 
		} else if (passLengthTest == false) {
			throw new IllegalArgumentException("The entered value must be 7 characters long."); 
		} else if (passPrimaryValidityTest == false) {
			throw new IllegalArgumentException("A hexadecimal color specification must begin with a '#'.");
		} else if (passSecondaryValidityTest == false) {
			throw new IllegalArgumentException ("You are using an invalid hexidecimal symbol (one of the six characters following the '#'). Valid hexidecimal symbols include digits 0-9 and letters A-F."); 
		}
		
		// now that you are certain all inputs are correct, distribute he converted RGB values into appropriate fields 
		red = Integer.parseInt(colorHexValue.substring(1,3), 16);  
		green = Integer.parseInt(colorHexValue.substring(3,5), 16); 
		blue = Integer.parseInt(colorHexValue.substring(5,7), 16);
		 
	}
	
	public Color (String colorHexValue, String colorName) {
		this.colorHexValue = colorHexValue; 
		this.colorName = colorName;

		// Test1: check that the first character is "#"
		if (Character.toString(colorHexValue.charAt(0)).equals("#")) {
			passPrimaryValidityTest = true; 
		}
		
		// Test2: check that all of the characters in colorHexValue following "#" are valid 
				for (int i = 1; i < colorHexValue.length(); i++){
					if (validHexValues.contains(Character.toString(colorHexValue.charAt(i)))){
						secondaryValidityTestCounter++;  
					} 
				}
				if (secondaryValidityTestCounter == 6) {
					passSecondaryValidityTest = true; 
				}
				
		// Test3: check that the string has the correct length 
		if (colorHexValue.length() == 7) {
			passLengthTest = true; 
		}
		
		// check that the entered argument meets all the criteria
		// if it doesn't meet one or more criteria, display a specific error message
		if (passLengthTest == true &&
			passPrimaryValidityTest == true &&
			passSecondaryValidityTest == true) {
			this.colorHexValue = colorHexValue; 
		} else if (passLengthTest == false) {
			throw new IllegalArgumentException("The entered value must be 7 characters long."); 
		} else if (passPrimaryValidityTest == false) {
			throw new IllegalArgumentException("A hexadecimal color specification must begin with a '#'.");
		} else if (passSecondaryValidityTest == false) {
			throw new IllegalArgumentException ("You are using an invalid hexidecimal symbol (one of the six characters following the '#'). Valid hexidecimal symbols include digits 0-9 and letters A-F."); 
		}
		
		// convert the hexadecimal value into RGB values
		red = Integer.parseInt(colorHexValue.substring(1,3), 16); 
		green = Integer.parseInt(colorHexValue.substring(3,5), 16); 
		blue = Integer.parseInt(colorHexValue.substring(5,7), 16); 
	}
	
	public Color (int red, int green, int blue) {
		
		// validate RGB input 
		if (red >= 0 && red <= 255 &&
			blue >= 0 && blue <= 255 &&
			green >= 0 && green <= 255) {
		this.red = red; 
		this.green = green; 
		this.blue = blue; 
		} else {
			throw new IllegalArgumentException ("The RGB values must be between 0 and 255, inclusive.");
		}
		
		// convert the RGB values into a hexadecimal value
		colorHexValue = "#"; 
		String tempHexValue; 
		
		// make sure that it is formatted correctly 
		// by adding 0's at the beginning of a substring where appropriate 
		int [] RGBforConversion = {red, green, blue}; 
		for (int i = 0; i < RGBforConversion.length; i++){
			if (Integer.toHexString(RGBforConversion[i]).length() >1) {
				tempHexValue = Integer.toHexString(RGBforConversion[i]); 
			} else {
				tempHexValue = "0" + Integer.toHexString(RGBforConversion[i]); 
			}
			colorHexValue = colorHexValue.concat(tempHexValue); 
		}
		
		
	}
	
	// Accessor Methods
	
	/**
	 * 
	 * Accesses the value of R in the Color's RGB description. 
	 * @param none
	 * @return red (the value of the red component).
	 * 
	 */
	int getRed() {
		return this.red; 
	}
	
	/**
	 * 
	 * Accesses the value of G in the Color's RGB description. 
	 * @param none
	 * @return green (the value of the green component).
	 * 
	 */
	int getGreen() {
		return this.green; 
	}
	
	/**
	 * 
	 * Accesses the value of B in the Color's RGB description. 
	 * @param none
	 * @return blue (the value of the blue component).
	 * 
	 */
	int getBlue() {
		return this.blue; 
	}
	
	/**
	 * 
	 * Accesses the name of the color. 
	 * @param none
	 * @return a string representing the name of the color.
	 * 
	 */
	String getName() {
		return this.colorName; 
	}
	/**
	 * 
	 * Accesses the HEX value of the color. 
	 * @param none
	 * @return HEX value.
	 * 
	 */
	String getHexValue() {
		return this.colorHexValue; 
	}
	
	// Comparisons 
	/**
	 * 
	 * Determines whether two Color objects are equal based on their HEX values. 
	 * Two objects will be considered equal if their HEX values are the same, regardless of upper- or lower case. 
	 * @param a Color object that you want to compare with the one you are working with.
	 * @return true if two Color objects are equal, false if they are not equal. 
	 * 
	 */
	public boolean equals(Color c) {
		if (this.colorHexValue.equalsIgnoreCase(c.colorHexValue)) {
			return true; 
		} else {
			return false; 
		}
	}
	
	public int compareTo(Color c){
		return colorHexValue.compareToIgnoreCase(c.colorHexValue); 
    }
	
	/**
	 * 
	 * Summarizes Color information (HEX value, RGB values, name) and displays it in a formatted string.  
	 * @param none
	 * @return a string representing a summary of a Color object of interest. 
	 * 
	 */
	// toString method 
	public String toString() {
		
		// if colorName is null, leave it out of the print statement 
		if (colorName == null){
			return String.format("%7s, (%3s,%3s,%3s)", colorHexValue.toUpperCase(), String.valueOf(red), String.valueOf(green), String.valueOf(blue)); 
		} else {
		// only print colorName if it is not null
		return String.format("%7s, (%3s,%3s,%3s), %s", colorHexValue.toUpperCase(), String.valueOf(red), String.valueOf(green), String.valueOf(blue), colorName); 
		}
	}
}