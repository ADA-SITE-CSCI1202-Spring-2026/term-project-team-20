package main.java.tasks;

import main.java.resources.Resource;
import java.util.Map;

public class EngineeringTask extends ColonyTask{
    private int powerRequired;
    public EngineeringTask(String name, int timeToFix, int requiredParts,int powerRequired ){
        super(name,timeToFix,requiredParts);
        this.powerRequired=powerRequired;
    }
    public int getPowerRequired(){
        return powerRequired;
    }
    @Override
    public String getProcessorType(){
        return "ENGINEERING";
    }
    @Override
    public Map<Resource,Integer> getResources(){
        return Map.of(Resource.SPARE_PARTS,requiredParts, Resource.POWER,powerRequired);
    }


}
