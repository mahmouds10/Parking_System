package main;

// Class to log the output to the console
public class ConsoleLogger implements Logger {
    private final String RESET = "\u001B[0m";

    // Log arrival state
    @Override
    public void logArrival(int carId, String gateName, int arrivalTime) {
        String GREEN = "\u001B[32m";
        System.out.printf(GREEN + "==> Car %d from %s arrived at time %d" + RESET + "\n", carId, gateName, arrivalTime);
    }

    // Log waiting state
    @Override
    public void logWaiting(int carId, String gateName, int occupied, int available) {
        String YELLOW = "\u001B[33m";
        System.out.printf(YELLOW + "⏳ Car %d from %s waiting for a spot. [Parking Status: %d spots occupied, %d spots available]" + RESET + "\n", carId, gateName, occupied, available);
    }

    // Log parking state
    @Override
    public void logParking(int carId, String gateName, int occupied, int available) {
        String BLUE = "\u001B[34m";
        System.out.printf(BLUE + "==| Car %d from %s parked. [Parking Status: %d spots occupied, %d spots available]" + RESET + "\n", carId, gateName, occupied, available);
    }

    // Log leaving state
    @Override
    public void logLeaving(int carId, String gateName, int parkingDuration, int occupied, int available) {
        String RED = "\u001B[31m";
        System.out.printf(RED + "<== Car %d from %s left after %d units of time. [Parking Status: %d spots occupied, %d spots available]" + RESET + "\n\n", carId, gateName, parkingDuration, occupied, available);
    }
}
