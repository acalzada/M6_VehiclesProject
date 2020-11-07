package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainApp {

	public static void main(String[] args) {
		
		//-----   FASE 1   -----
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please enter your plate number: ");
		String plate ="";
		do{
			plate = scanner.nextLine();
			if ( !Car.plateIsCorrect(plate) )
			{
				System.out.println("\033[31m ! Plate error: \033[0m The plate must be 4 digits + white space + 2 or 3 letters.\n");
				System.out.print("Please enter the plate again: ");
			}
			
		}while( !Car.plateIsCorrect(plate) );  // Plate must be 4 digits + white space + 2 or 3 letters
		
		System.out.print("Please enter your car brand: ");
		String brand = scanner.nextLine();
		System.out.print("Please enter your car color: ");
		String color = scanner.nextLine();
		
		System.out.println("\nYour car information is: \n\n" + 
							" - plate: '" + plate + "'\n" + 
							" - brand: '" + brand + "'\n" +
							" - color: '" + color + "'\n\n");

		
		Car car = new Car(plate, brand, color);
		
		
		System.out.print("Adding rear wheels for your car.\n"
				       + "--------------------------------\n");
		
		System.out.print("Please enter the brand of the rear wheels: ");
		String rearWheelsBrand = scanner.nextLine();
		
		
		System.out.print("Please enter the diametter of the rear wheels: ");
		Double rearWheelsDiameter = 0.0;
		do {
			rearWheelsDiameter = Double.parseDouble(scanner.nextLine());
			if ( !Wheel.wheelDiameterIsCorrect(rearWheelsDiameter) ) {
				System.out.println("\033[31m ! Diameter error: \033[0m Wheel diameters must be higher than 0.4 and lower than 4.");
				System.out.println("Please enter a correct diameter: ");
			}
		}while( !Wheel.wheelDiameterIsCorrect(rearWheelsDiameter) );
		
		
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
		Double frontWheelsDiameter = 0.0;
		
		do {
			frontWheelsDiameter = Double.parseDouble(scanner.nextLine());
			if ( !Wheel.wheelDiameterIsCorrect(frontWheelsDiameter) ) {
				System.out.println("\033[31m ! Diameter error: \033[0m Wheel diameters must be higher than 0.4 and lower than 4.");
				System.out.println("Please enter a correct diameter: ");
			}
		}while( !Wheel.wheelDiameterIsCorrect(frontWheelsDiameter) );
		
		
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
