package org.parkingsystem;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<BikeSpot> bikeSpotList = new ArrayList<>();
    List<CompactSpot> compactSpotList = new ArrayList<>();
    List<LargeSpot> largeSpotList = new ArrayList<>();
    int freeBikeSpots;
    int freeCompactSpots;
    int freeLargeSpots;
    public ParkingLot(int freeBikeSpots, int freeCompactSpots, int freeLargeSpots) {
        this.freeBikeSpots = freeBikeSpots;
        this.freeCompactSpots = freeCompactSpots;
        this.freeLargeSpots = freeLargeSpots;
    }
    public void parkVehicle(Vehicle vehicle){
         if(vehicle.getVehicleType().equals(VehicleType.TRUCK)){
               if(freeLargeSpots > 0){
                   parkInLargeSpot(vehicle);
               }else{
                   System.out.println("Sorry our large Spots are full");
               }
         }else if(vehicle.getVehicleType().equals(VehicleType.CAR)){
               if(freeCompactSpots > 0){
                   parkInCompactSpot(vehicle);
               }else if(freeLargeSpots > 0){
                   parkInLargeSpot(vehicle);
               }else{
                   System.out.println("Sorry neither compacts nor large are full");
               }
         }else if(vehicle.getVehicleType().equals(VehicleType.BIKE)){
             if(freeBikeSpots > 0){
                 parkInBikeSpot(vehicle);
             } else if(freeCompactSpots > 0){
                 parkInCompactSpot(vehicle);
             }else if(freeLargeSpots > 0){
                 parkInLargeSpot(vehicle);
             }else{
                 System.out.println("Sorry all the Spots are full");
             }
         }
    }

    void parkInLargeSpot(Vehicle vehicle){
        LargeSpot largeSpot= new LargeSpot(ParkingSpotType.LARGE);
        largeSpot.setFree(false);
        largeSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(largeSpot);
        largeSpotList.add(largeSpot);
        System.out.println("We have successfully parked your "+ vehicle.getVehicleType()+" in "+
                largeSpot.getType()+" spot");
        freeLargeSpots--;
    }

    void parkInCompactSpot(Vehicle vehicle){
        CompactSpot compactSpot= new CompactSpot(ParkingSpotType.COMPACT);
        compactSpot.setFree(false);
        compactSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(compactSpot);
        compactSpotList.add(compactSpot);
        System.out.println("We have successfully parked your "+ vehicle.getVehicleType()+" in "+
                compactSpot.getType()+" spot");
        freeCompactSpots--;
    }

    void parkInBikeSpot(Vehicle vehicle){
        BikeSpot bikeSpot= new BikeSpot(ParkingSpotType.BIKE);
        bikeSpot.setFree(false);
        bikeSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(bikeSpot);
        bikeSpotList.add(bikeSpot);
        System.out.println("We have successfully parked your "+ vehicle.getVehicleType()+" in "+
                bikeSpot.getType()+" spot");
        freeBikeSpots--;
    }

    public void unParkVehicle(Vehicle vehicle){
        System.out.println("We are about to unpark your "+ vehicle.getVehicleType());
        ParkingSpot parkingSpot= vehicle.getParkingSpot();
        parkingSpot.setFree(true);
        if(parkingSpot.getType().equals(ParkingSpotType.LARGE)){
            largeSpotList.remove(parkingSpot);
            System.out.println("The vehicle is removed from large spot");
            freeLargeSpots++;
        }else if(parkingSpot.getType().equals(ParkingSpotType.COMPACT)){
            compactSpotList.remove(parkingSpot);
            System.out.println("The vehicle is removed from compact spot");
            freeCompactSpots++;
        }else if(parkingSpot.getType().equals(ParkingSpotType.BIKE)){
            bikeSpotList.remove(parkingSpot);
            System.out.println("The vehicle is removed from bike spot");
            freeBikeSpots++;
        }
    }
}
