package main;

// Class to handle car thread
public class Car extends Thread {
    // The gate that care has arrived
    private final String gateName;
    // Car id
    private final int carId;
    // Arrival time
    private final int arrivalTime;
    // Parking duration
    private final int parkingDuration;
    // Logger object to print the data
    private final Logger logger;

    // Constructor
    public Car(String gateName, int carId, int arrivalTime, int parkingDuration, Logger logger) {
        this.gateName = gateName;
        this.carId = carId;
        this.arrivalTime = arrivalTime;
        this.parkingDuration = parkingDuration;
        this.logger = logger;
    }

    @Override
    public void run() {
        try {
            // Simulate the arrival time
            Thread.sleep(arrivalTime * 1000L);
            // Print the arrival line
            logger.logArrival(carId, gateName, arrivalTime);

            // Check for available spot
            if (ParkingSystem.parkingSpots.tryAcquire()) {
                // If available spot print the parking line
                logger.logParking(carId, gateName,
                        ParkingSystem.PARKING_SPOTS - ParkingSystem.parkingSpots.availablePermits(),
                        ParkingSystem.parkingSpots.availablePermits()
                );

                // Stop the thread to simulate the parking duration
                Thread.sleep(parkingDuration * 1000L);

                // Increment the semaphore counter after car leaving
                ParkingSystem.parkingSpots.release();

                // Print the Leaving line
                logger.logLeaving(carId, gateName, parkingDuration,
                        ParkingSystem.PARKING_SPOTS - ParkingSystem.parkingSpots.availablePermits(),
                        ParkingSystem.parkingSpots.availablePermits()
                );
            } else {

                // Print the waiting line
                logger.logWaiting(carId, gateName,
                        ParkingSystem.PARKING_SPOTS - ParkingSystem.parkingSpots.availablePermits(),
                        ParkingSystem.parkingSpots.availablePermits()
                );

                // Park the car and decrease the semaphore counter
                ParkingSystem.parkingSpots.acquire();

                // Print parking line
                logger.logParking(carId, gateName,
                        ParkingSystem.PARKING_SPOTS - ParkingSystem.parkingSpots.availablePermits(),
                        ParkingSystem.parkingSpots.availablePermits()
                );

                // Stop the thread to simulate the parking duration
                Thread.sleep(parkingDuration * 1000L);

                // Increment the semaphore counter after car leaving
                ParkingSystem.parkingSpots.release();

                // Print the leaving line
                logger.logLeaving(carId, gateName, parkingDuration,
                        ParkingSystem.PARKING_SPOTS - ParkingSystem.parkingSpots.availablePermits(),
                        ParkingSystem.parkingSpots.availablePermits()
                );
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
