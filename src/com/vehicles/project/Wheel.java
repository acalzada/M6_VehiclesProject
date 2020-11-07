package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}
	
	public String getWheelInfo() {
		String info = " - brand: '" + this.brand + "'\t <--> " +
					  "diameter: '" + this.diameter + "'\n";
		
		return info;
	}
	
	public static Boolean wheelDiameterIsCorrect(double diameter) {
		if (diameter > 0.4 && diameter < 4) {
			return true;
		}
		return false;
	}
	
}
