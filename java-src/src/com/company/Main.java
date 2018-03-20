package com.company;

import java.io.IOException;

public class Main {

    /**
     * Constructor method
     *
     */
    public static void main(String[] args) throws IOException {
        // Set speed of iteration (default to once per second)
        int speed = 1;
        if (args.length > 0) {
            try {
                speed = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[0] + " must be an integer speed in seconds.");
                System.exit(1);
            }
        }

        // Establish Shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run() {
                System.out.println("Shutdown hook ran!");
            }
        });

        // Instantiate a processes object to monitor processes
        Processes processes = new Processes();

        // Loop on at the input 'speed' until exit signal
        try {
            while (true) {
                // Refresh the process list
                processes.getList();

                // Parse Process list in Json into looping log file
                processes.logToFile();

                // Parse Process list via Data Model to Database
                processes.logToDB();

                // Start again at the currently set speed
                Thread.sleep(speed * 1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
