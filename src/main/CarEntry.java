package main;

// Class to carry the data of car entry
public class CarEntry {
    // Card id
    private final int carId;
    // Arrival time
    private final int arrivalTime;
    // Parking duration
    private final int parkingDuration;

    // Constructor
    public CarEntry(int carId, int arrivalTime, int parkingDuration) {
        this.carId = carId;
        this.arrivalTime = arrivalTime;
        this.parkingDuration = parkingDuration;
    }

    // carId getter
    public int getCarId() { return carId; }
    // Arrival time getter
    public int getArrivalTime() { return arrivalTime; }
    //Parking duration getter
    public int getParkingDuration() { return parkingDuration; }
}
