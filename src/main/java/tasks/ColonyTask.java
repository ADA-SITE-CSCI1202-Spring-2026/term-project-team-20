package main.java.tasks;
import main.java.resources.Resource;

import java.util.*;
public abstract class ColonyTask {
    protected String name;
    protected int timeToFix;
    protected int requiredParts;

    public ColonyTask(String name, int timeToFix, int requiredParts){
        this.name=name;
        this.timeToFix=timeToFix;
        this.requiredParts=requiredParts;
    }
    public String getName(){

        return name;
    }
    public int getTimetoFix(){
        return timeToFix;
    }
    public int getRequiredParts(){
        return requiredParts;
    }
    public abstract Map <Resource,Integer> getResources();
    public abstract String getProcessorType();
}
