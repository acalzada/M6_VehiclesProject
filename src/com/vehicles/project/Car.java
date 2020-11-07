package com.vehicles.project;

import java.util.List;

public class Car extends Vehicle {

	public Car(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}

	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel))
			throw new Exception();

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}
	
	public String toString() {
		String info = "Car information \n -------------------\n";
		
		info = info + " - plate: " + this.plate + "\n" +
					  " - brand: " + this.brand + "\n" +
					  " - color: " + this.color + "\n\n" +
					  " Wheels info \n ----------------- \n";
		
		for(Wheel wheel : this.wheels) {
			info = info + wheel.getWheelInfo();
		}
					
		return info;
	}

}
