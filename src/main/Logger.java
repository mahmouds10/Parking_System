package main;

public interface Logger {
    void logArrival(int carId, String gateName, int arrivalTime);
    void logWaiting(int carId, String gateName, int occupied, int available);
    void logParking(int carId, String gateName, int occupied, int available);
    void logLeaving(int carId, String gateName, int parkingDuration, int occupied, int available);
}
