package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}
	
	public String getWheelInfo() {
		String info = " - 'brand': " + this.brand + "\t <--> " +
					  "'diameter': " + this.diameter +"\n";
		
		return info;
	}
}
