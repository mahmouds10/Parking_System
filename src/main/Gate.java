package main;

import java.util.List;

// Class to handle gate thread
public class Gate extends Thread {
    // Gate name
    private final String gateName;
    // Loader object to read the data
    private final CarScheduleLoader carScheduleLoader;
    // Logger object to print data
    private final Logger logger;

    // Constructor
    public Gate(String gateName, CarScheduleLoader carScheduleLoader, Logger logger) {
        this.gateName = gateName;
        this.carScheduleLoader = carScheduleLoader;
        this.logger = logger;
    }

    @Override
    public void run() {
        // Declaring an ArrayList to carry the data returned from calling the load function
        List<CarEntry> carEntries = carScheduleLoader.loadCarEntries(gateName);
        // Loop the list to create Car object for each entry
        for (CarEntry entry : carEntries) {
            // Create the Car object
            Car car = new Car(gateName, entry.getCarId(), entry.getArrivalTime(), entry.getParkingDuration(), logger);
            // Start the thread
            car.start();
            try {
                // Small delay to stagger car starts
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
