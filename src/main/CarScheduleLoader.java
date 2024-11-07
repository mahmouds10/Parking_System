package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Class to read the data from input file
public class CarScheduleLoader {
    // Input file source path
    private final String filePath;

    // Constructor
    public CarScheduleLoader(String filePath) {
        this.filePath = filePath;
    }

    // Function to read the data from the file
    public List<CarEntry> loadCarEntries(String gateName) {
        // Declaring an ArrayList to carry the CarEntries read from files
        List<CarEntry> carEntries = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                // Split the line
                String[] parts = line.split(", ");

                // Identify current gate
                String currentGate = parts[0];

                // Check if valid gate
                if (!currentGate.equals(gateName)) continue;


                // Identify the carId
                int carId = Integer.parseInt(parts[1].split(" ")[1]);
                // Identify the arrival time
                int arrivalTime = Integer.parseInt(parts[2].split(" ")[1]);
                // Identify the parking duration
                int parkingDuration = Integer.parseInt(parts[3].split(" ")[1]);

                // Instantiate object from CarEntry using the data and add to the ArrayList
                carEntries.add(new CarEntry(carId, arrivalTime, parkingDuration));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return carEntries;
    }
}
