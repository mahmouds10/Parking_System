package main;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingSystem {
    public static final int PARKING_SPOTS = 4;
    public static final Semaphore parkingSpots = new Semaphore(PARKING_SPOTS, true);

    public static void main(String[] args) {
        String filePath = "src/resources/input.txt";

        // Initialize the car schedule loader
        CarScheduleLoader carScheduleLoader = new CarScheduleLoader(filePath);

        // Initialize the logger
        Logger logger = new ConsoleLogger();

        // Initialize and start each gate with the car schedule loader and logger
        Gate gate1 = new Gate("Gate 1", carScheduleLoader, logger);
        Gate gate2 = new Gate("Gate 2", carScheduleLoader, logger);
        Gate gate3 = new Gate("Gate 3", carScheduleLoader, logger);


        // Start each gate thread
        gate1.start();
        gate2.start();
        gate3.start();
    }
}
