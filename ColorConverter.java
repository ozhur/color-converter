/**
 * This class creates a ColorList that contains information about a number of Color Objects
 * extracted from a given .txt file.  
 * It then allows the user to access the available information about a particular Color Object, 
 * such as its name and RGB value, based on its HEX value alone. 
 * 
 * @author Olga Zhurakivska
 * @version 09/20/2017
 * 
 * 
 */

package project1;

import java.io.File;
import java.util.Scanner; 

public class ColorConverter {

	// need to handle the I/O exception
	public static void main(String[] args) throws Exception {
		
		ColorList myList = new ColorList();
		
		try {
		// create an instance of file
		File textFile = new File(args[0]); 
		//if no file specified, quit the program
		
		
		
		// if entered file does not exist, quit the program
		if (!textFile.exists()) {
			System.err.println("Error: the file " + args[0] + " does not exist."); 
			System.exit(2); 
		}
		
		// reads the file entered as the first argument in the command line
		Scanner input = new Scanner(textFile);
		String [] elements;  
		
		// read the file line by line and separate the name of the color from its hex value  
		while (input.hasNext()) {
			elements = input.nextLine().split(","); 
			
			for (int i = 0; i < elements.length; i++) {
				
				// trims all the white characters in each of the strings
				elements[i] = elements[i].trim(); 
				
				}	
			
			// passes the appropriate strings as parameters in the Color object
			Color myColor = new Color (elements[1], elements[0]); 
			
			// adds the newly created Color object to the list
			myList.add(myColor); 
			}
	
		// after you've read the entire file, close the scanner 
		input.close(); 
		
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Usage error: The program expects a file name as an argument."); 
			System.exit(1);
		}
		
		try {
		// accept user input as long as the user does not choose to quit
		Scanner readInput = new Scanner(System.in); 
		String userInput = ""; 
		while (!userInput.equals("quit")){
			
			System.out.println("Enter the color in HEX format (#RRGGBB) or \"quit\" to stop:"); 
			userInput = readInput.nextLine(); 
			
			if (!userInput.equals("quit")) {
				Color selectedColor = myList.getColorByHexValue(userInput);
				if (selectedColor == null){
					System.err.println("The entered HEX value is not in the list of colors."); 
				} else {
				System.out.println("Color information:"); 
				System.out.println(selectedColor.toString()); 
				}
			}
			
		}
		// if the user enters "quit," terminate the program
		System.exit(0); 
		} catch (NullPointerException e) {}; 
		
		

	}

}
