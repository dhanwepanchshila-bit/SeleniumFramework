package javap;

//in java almost everything is an object
	//Real time objects ex - Car, Mobile, Employee, Students etc
	//Object Vs Class - 
	//Class -> Class is a blueprint -> Ex Car Banvychi Blueprint->It defines Properties(Color, Speed) and Behaviour(Start, Stop)
	//Object-> Object Means Actual entity created from class- Means blueprint varun actual car ready zali=object
	
//Code Example

public class Car {
	
	String Color;
	int Speed;
	
	public void start() {
		
		System.out.println(Color+ " Car started with the speed of "+Speed);
	}
	
	//above is class we will now create its object as below in main method
	
	public static void main(String[] args) {
		
		Car c1 = new Car();
		c1.Color ="Red";
		c1.Speed = 50;
		c1.start();
	}

}
