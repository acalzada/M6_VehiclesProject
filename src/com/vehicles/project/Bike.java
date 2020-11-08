package com.vehicles.project;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
		this.wheels.add(null); // Wheel with index 0 corresponds to the front wheel
		this.wheels.add(null); // Wheel with index 1 corresponds to the rear wheel
	}
	
	public void addFrontWheel(Wheel wheel)
	{
		// Wheel with index 0 corresponds to the front wheel
		this.addWheel(0, wheel);
	}
	
	public void addRearWheel(Wheel wheel)
	{
		// Wheel with index 1 corresponds to the rear wheel
		this.addWheel(1, wheel);
	}
	
	private void addWheel(int index, Wheel wheel) {
		if ( Wheel.wheelDiameterIsCorrect(wheel.getDiameter()) )
		{
			// Wheel with index 0 corresponds to the front wheel
			// Wheel with index 1 corresponds to the rear wheel
			this.wheels.set(index, wheel);
		}else {
			throw new IllegalArgumentException("Bad Wheel diameter: Wheel diameter must be greater than 0.4 and smaller than 4.");
		}
	}
	
	public String toString()
	{
		String info = "\n   Bike information \n -------------------\n";
		
		info = info + " - plate: '" + this.plate + "'\n" +
					  " - brand: '" + this.brand + "'\n" +
					  " - color: '" + this.color + "'\n\n" +
					  "   Wheels info \n ----------------- \n";
		
		for(Wheel wheel : this.wheels) {
			info = info + wheel.getWheelInfo();
		}
					
		return info;
	}
}
