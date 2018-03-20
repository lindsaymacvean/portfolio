package com.company;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Represents a list of currently running processes.
 * @author Lindsay MacVean
 * @version 0.1
 */
public class Processes {

    /**
     * Create logger
     */
    final static Logger logger = Logger.getRootLogger();

    /**
     * The list of processes
     */
    private List<String> processes = new ArrayList<>();

    /**
     * This is getter for last captured processes
     * from the last time this.getlist() was run
     */
    public List<String> list() {
        return processes;
    }

    /**
     * The constructor
     * Instantiates and gets an initial list of processes
     */
    public Processes() {
        this.processes = this.getList();
    }

    /**
     * Returns a list of processes currently running on the machine
     * <p>
     * This method uses Runtime.getRuntime().exec("ps -e")
     * Its public
     *
     * @return returns a new list of processes
     */
    public List<String> getList() {
        try {
            String line;
            Process p = Runtime.getRuntime().exec("ps -e");
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                processes.add(line);
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
        return processes;
    }

    /**
     * Updates list of processes and logs to /var/log
     *
     */
    public void logToFile() throws IOException {
        Iterator<String> iterator = processes.iterator();
        while (iterator.hasNext()) {
            if(logger.isInfoEnabled()){
                logger.info("This is info : " + iterator.next());
            }
        }
    }

    public void logToDB() {

    }
}
