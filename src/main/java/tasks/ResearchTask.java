package main.java.tasks;

import main.java.resources.Resource;

import java.util.Map;

public class ResearchTask extends ColonyTask{
    private int rationsRequired;

    public ResearchTask(String name, int timeToFix, int requiredParts, int rationsRequired) {
       super(name, timeToFix, requiredParts);
       this.rationsRequired = rationsRequired;
    }

    public int getRationsRequired() {
        return rationsRequired;
    }

    @Override
    public Map<Resource,Integer> getResources()
    {
        return Map.of(Resource.SPARE_PARTS, requiredParts, Resource.RATIONS, rationsRequired);
    }

    @Override
    public String getProcessorType()
    {
        return "RESEARCH";
    }
}