package com.incomehigher;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

public class Application {


    final MainCLIParameters mainArgs = new MainCLIParameters();

    public static void main(String[] args) {
    	Application demo = new Application();
        demo.handleInputArgs(args);
        demo.run();
    }

    void handleInputArgs(String args[]) {
        JCommander jCommander = new JCommander(mainArgs);
        jCommander.setProgramName("archive");

        try {
            jCommander.parse(args);
        } catch (ParameterException exception) {
            System.out.println(exception.getMessage());
            showUsage(jCommander);
        }

        if (mainArgs.isHelp()) {
            showUsage(jCommander);
        }
      
    }
    
    void showUsage(JCommander jCommander) {
        jCommander.usage();
        System.exit(0);
    }
    
    void run() {
        System.out.println("Running archive with ...");
        System.out.println(mainArgs);
    }

}
