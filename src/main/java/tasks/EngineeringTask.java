package main.java.tasks;
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
    public void getProcessorType(){
        return "ENGINEERING"
    }
    @Override
    public Map<Resource,Integer> getResources(){
        return Map.of(Resources.Spare_Parts,powerRequired);
    }


}
