package com.incomehigher;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Parameters(separators = "=") //space works too
public class MainCLIParameters {

    @Parameter(names = {"-h", "--help"},
            help = true, //if not then will get ..."The following option is required: -p, --profile"
            description = "Displays help information")
    private boolean help;
    
    @Parameter(names = {"-z", "--zipped"},
            arity = 1,
            description = "flag to toggle zipping of archive")
    private boolean zipped = true;

    @Parameter(names = {"-i", "--interval"},
            description = "The interval in minutes at which the archives are taken")
    private Integer interval = 60;  //default of 1 hour (60 min)

    @Parameter(names = {"-u", "--users"},
            variableArity = true,
            description = "List of users whose home directories will be archived as per profile."
            + "If no users are specified the default is to archives all users")
    public List<String> users = new ArrayList<String>();

    public boolean isHelp() {
        return help;
    }

    @Override
    public String toString() {
        return "\nhelp=" + help + 
                "\nzipped=" + zipped + 
                "\ninterval=" + interval  +
                "\nusers=" + users ;
    }
    
    

}