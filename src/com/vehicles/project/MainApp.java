package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainApp {

	public static void main(String[] args) {
		
		//-----   FASE 3   -----
		Scanner scanner = new Scanner(System.in);
		String option = "";
		do {
			System.out.print("Please choose the vehicle to create:\n" + 
					 "1) Car\n" +
					 "2) Bike\n");
			option = scanner.nextLine();
			
			if ( !option.contentEquals("1") && !option.contentEquals("2") )
			{
				System.out.println("\033[31m ! Unkown option: \033[0m Please enter 1 or 2.\n");
			}
			
		}while(!option.equals("1") && !option.equals("2"));
		
		switch(option)
		{
		case("1"): MainApp.createCar(scanner);
				 break;
		case("2"): MainApp.createBike(scanner);
				 break;
		}
		scanner.close();
	}
	
	private static ArrayList<String> getBasicVehicleInfo(Scanner scanner)
	{
		ArrayList<String> basicVehicleInfo = new ArrayList<String>();
		
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
		
		System.out.println("\nYour vehicle's basic information is: \n\n" + 
							" - plate: '" + plate + "'\n" + 
							" - brand: '" + brand + "'\n" +
							" - color: '" + color + "'\n\n");
		
		basicVehicleInfo.add(plate);
		basicVehicleInfo.add(brand);
		basicVehicleInfo.add(color);
		
		return basicVehicleInfo;
	}
	
	
	private static void createCar(Scanner scanner)
	{
		//-----   FASE 1   -----
		
		System.out.println("   We are going to create a new Car\n"+
				   		   "  ------------------------------------\n");

		
				ArrayList<String> basicVehicleInfo = MainApp.getBasicVehicleInfo(scanner);

				
				Car car = new Car(basicVehicleInfo.get(0), basicVehicleInfo.get(1), basicVehicleInfo.get(2));
				
				
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
	}

	private static void createBike(Scanner scanner)
	{
		System.out.println("   We are going to create a new Bike\n"+
						   "  ------------------------------------\n");
		
		ArrayList<String> basicVehicleInfo = MainApp.getBasicVehicleInfo(scanner);

		
		Bike bike = new Bike(basicVehicleInfo.get(0), basicVehicleInfo.get(1), basicVehicleInfo.get(2));
		System.out.println("Please enter Front wheel information:");
		System.out.print("Please enter the brand: ");
		String wheelBrand = scanner.nextLine();
		double wheelDiameter = requestWheelDiameter(scanner);
		
		bike.addFrontWheel(new Wheel(wheelBrand, wheelDiameter));
		
		System.out.println("Please enter Rear wheel information:");
		System.out.print("Please enter the brand: ");
		wheelBrand = scanner.nextLine();
		
		wheelDiameter = requestWheelDiameter(scanner);
		
		bike.addRearWheel(new Wheel(wheelBrand, wheelDiameter));
		
		System.out.println("\nYour Bike has been created with the following features:\n\n" + 
							bike.toString());
	}
	
	private static double requestWheelDiameter(Scanner scanner)
	{
		double diameter = 0.0;

		do {
			System.out.print("PLease enter the wheel diameter: ");
			diameter = Double.parseDouble(scanner.nextLine());
			if ( !Wheel.wheelDiameterIsCorrect(diameter) ) {
				System.out.println("\033[31m ! Diameter error: \033[0m Wheel diameters must be higher than 0.4 and lower than 4.");
				System.out.println("Please enter a correct wheel diameter: ");
			}
		}while( !Wheel.wheelDiameterIsCorrect(diameter) );
		return diameter;
	}
}
