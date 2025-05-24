# Car Parking System Using Threads

This project simulates a car parking system using multithreading in Java. Each car tries to enter the parking lot, and gates handle the entry, while a logger records events.

## Features

- Simulates real-world car parking with entry gates.
- Uses Java Threads to represent car entries.
- Synchronized logging to ensure accurate event reporting.
- Schedules car entries via a configurable loader.

## Project Structure

```
src/
├── Car.java               # Represents a car with attributes like ID, entry time, etc.
├── CarEntry.java          # Runnable class to simulate a car trying to enter the gate.
├── CarScheduleLoader.java # Loads the car schedule from a source (e.g., file or array).
├── ConsoleLogger.java     # Logs messages to the console.
├── Gate.java              # Represents a parking gate managing access control.
├── Logger.java            # Abstract logger interface or superclass.
└── ParkingSystem.java     # Main class initializing the system, scheduling cars, and running the simulation.
```

## How It Works

1. `CarScheduleLoader` loads car entries to be processed.
2. Each car entry creates a thread (`CarEntry`) that simulates arriving at a gate.
3. Gates control access to the parking system, using synchronization to prevent overfill or race conditions.
4. `Logger` and `ConsoleLogger` record events like car entry, waiting, and rejection.

## How to Run

1. Compile the project:
   ```bash
   javac *.java
   ```
2. Run the main class:
   ```bash
   java ParkingSystem
   ```

## Customization

- Modify `CarScheduleLoader` to change arrival schedules.
- Add delays to simulate real-time entry attempts.
- Implement new loggers for file-based logs or GUI-based visualization.

## Example Log Output

```
==> Car 0 from Gate 1 arrived at time 0
==| Car 0 from Gate 1 parked. [Parking Status: 1 spots occupied, 3 spots available]
⏳ Car 3 from Gate 1 waiting for a spot. [Parking Status: 4 spots occupied, 0 spots available]
<== Car 0 from Gate 1 left after 3 units of time. [Parking Status: 3 spots occupied, 1 spots available]

=== Simulation Summary ===
Total Cars Served:  15
Current Cars in Parking: 0
Parking spots available: 4
Details : 
Gate 1 served  5 cars
Gate 2 served  5 cars
Gate 3 served  5 cars
```

## License

This project is open-source and free to use for educational purposes.

© 2025 Car Parking System by Mahmoud Sayed
