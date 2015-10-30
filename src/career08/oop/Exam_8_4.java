package career08.oop;

import java.util.List;

public class Exam_8_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

enum VehicleSize{
	Motorcycle, Compact, large;
}

abstract class Vehicle{
	
	 List<ParkingSpot> parkingSpots;
	 String licensePlate;
	 int spotNeeded;
	 VehicleSize size;
	 
	 void parkInSpot(ParkingSpot sp){}
	 void clearSplots(){}
	 abstract boolean canFitInSpot(ParkingSpot sp);
	
}



class Bus extends Vehicle{
	  boolean canFitInSpot(ParkingSpot sp) {throw new RuntimeException("to do");} 
}

class Car extends Vehicle{
	  boolean canFitInSpot(ParkingSpot sp) {throw new RuntimeException("to do");} 
}


class Motorcycle extends Vehicle{
	boolean canFitInSpot(ParkingSpot sp) {throw new RuntimeException("to do");} 
}


class ParkingLot{
	private Level[] levels;
	private final int NUM_LEVELS = 5;
	public boolean parkVehicle(Vehicle v){ throw new RuntimeException("to do");} 
} 


class Level{
	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots = 0;
	private static final int SPOTS_PER_ROW = 10;
	public boolean parkVehicle(Vehicle v){ throw new RuntimeException("to do");} 
    private int findAvailableSpots(Vehicle v) {throw new RuntimeException("to do");}; 
	public void spotFreed() {}
}

class ParkingSpot{
	Vehicle v;
	 VehicleSize size;
	 int row;
	 int spotNumber;
	 Level level;
	 
	 boolean isAvailable() {throw new RuntimeException("to do");}
	 boolean canFitVehicle(Vehicle v) {throw new RuntimeException("to do");}
	 boolean park(Vehicle v) {throw new RuntimeException("to do");}
	 void removeVehicle() {}
	
}


