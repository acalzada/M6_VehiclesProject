package com.vehicles.project;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vehicles.project.Car.*;
import com.vehicles.project.Wheel;

public class MainApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please enter your plate number: ");
		String plate = scanner.nextLine();
		System.out.print("Please enter your car brand: ");
		String brand = scanner.nextLine();
		System.out.print("Please enter your car color: ");
		String color = scanner.nextLine();
		
		System.out.println("\nYour car information is: \n\n" + 
							" - plate: " + plate + "\n" + 
							" - brand: " + brand + "\n" +
							" - color: " + color + "\n\n");
		
		Car car = new Car(plate, brand, color);
		
		
		
		System.out.print("Adding rear wheels for your car.\n"
				       + "--------------------------------\n");
		
		System.out.print("Please enter the brand of the rear wheels: ");
		String rearWheelsBrand = scanner.nextLine();
		
		
		System.out.print("Please enter the diametter of the rear wheels: ");
		Double rearWheelsDiameter = Double.parseDouble(scanner.nextLine());
		
		List<Wheel> rearWheels = new ArrayList<Wheel>();
		rearWheels.add(new Wheel(rearWheelsBrand, rearWheelsDiameter));
		rearWheels.add(rearWheels.get(0));
		
		try {
			// Add only rear wheels specifications leaving front wheels blank.
			car.addTwoWheels(rearWheels);
		} catch (Exception e) {
			e.printStackTrace();
			scanner.close();
		}
		
		System.out.print("\nAdding front wheels for your car. \n"
				       + "----------------------------------\n");
		System.out.print("Please enter the brand of the front wheels: ");
		String frontWheelsBrand = scanner.nextLine();
		
		System.out.print("Please enter the diametter of the front wheels: ");
		Double frontWheelsDiameter = Double.parseDouble(scanner.nextLine());
		
		List<Wheel> frontWheels = new ArrayList<Wheel>();
		frontWheels.add(new Wheel(frontWheelsBrand, frontWheelsDiameter));
		frontWheels.add(frontWheels.get(0));
		
		try {
			// Add front wheels specifications leaving front wheels blank.
			car.addTwoWheels(frontWheels);
		} catch (Exception e) {
			e.printStackTrace();
			scanner.close();
		}
		
		System.out.println("\n\n" + car.toString());
		
		scanner.close();
		
		

	}

}
