package org.parkingsystem;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(2,2,2);
        Vehicle v1 = new Vehicle(VehicleType.CAR);
        Vehicle v2 = new Vehicle(VehicleType.CAR);
        Vehicle v3 = new Vehicle(VehicleType.CAR);
        parkingLot.parkVehicle(v1);
        parkingLot.parkVehicle(v2);
        parkingLot.parkVehicle(v3);

        parkingLot.unParkVehicle(v1);
        parkingLot.unParkVehicle(v2);
        parkingLot.unParkVehicle(v3);
    }
}