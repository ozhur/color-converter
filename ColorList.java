/**
 * This class represents a ColorList Object. 
 * It is an extension of the ArrayList class and can be populated with Objects of type Color. 
 * 
 * @author Olga Zhurakivska
 * @version 09/20/2017
 * 
 * 
 */


package project1;

import java.util.ArrayList;

public class ColorList extends ArrayList<Color>{

	public ColorList() {	
	}
	/**
	 * 
	 * Accesses a particular Color in a ColorList based on its name and returns all the other available information. 
	 * @param the name of the color.
	 * @return the Color object itself provided that it is found.
	 * 
	 */
	public Color getColorByName(String colorName) {
		Color foundColor = null;  
		//create a Color object with null fields and fill them out based on the information in your ColorList
		// if the requested colorName matches one in the list  
		try {
			for (int i = 0; i < this.size(); i++) {
				Color currentColor = this.get(i); 
				String currentColorName =  currentColor.getName(); 
				if (currentColorName.equalsIgnoreCase(colorName)) {
					foundColor = currentColor;  
					}
				}
			} catch (NullPointerException e) {
				System.err.println("NullPointerException caught!"); 
			}
		
		return foundColor; 
	}
	
	/**
	 * 
	 * Accesses a particular Color object in a ColorList based on its HEX value. 
	 * @param the HEX value of the color of interest.
	 * @return the Color object itself (provided that it is found). 
	 * 
	 */
	public Color getColorByHexValue(String colorHexValue) {
		Color foundColor = null; 
		try {
			for (int i = 0; i < this.size(); i++) {
				Color currentColor = this.get(i); 
				String currentHexValue = currentColor.getHexValue(); 
				if (currentHexValue.equalsIgnoreCase(colorHexValue)) {
					foundColor = currentColor;
				} 
			  }
		} catch (NullPointerException e) {
			System.err.println("NullPointerException caught!"); 
			}
		return foundColor;
	}
}
