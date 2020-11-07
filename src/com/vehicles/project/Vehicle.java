package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();

	public Vehicle(String plate, String brand, String color) {
		
		if( plateIsCorrect(plate) ) 
		{
			this.plate = plate;
			this.brand = brand;
			this.color = color;
		}else {
			throw new IllegalArgumentException("Plate error: The vehicle plate must contain 3 numbers + white space + 2 or 3 letters."); 
		}
	}
	
	
	//-----   FASE 2   -----
	
	//-----   FASE 2   -----
	
	public static Boolean plateIsCorrect(String plate) {
		
		// Plate must contain 4 numbers + white space + 2 or 3 letters
		if (plate.matches("\\d\\d\\d\\d\\s\\w\\w\\w?")) {
			return true;
		}
		return false;
	}
}
