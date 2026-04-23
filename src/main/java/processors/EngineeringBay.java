package main.java.processors;
import main.java.tasks.ColonyTask;
import main.java.tasks.EngineeringTask;

public class EngineeringBay implements IProcessors {
    @Override
    public String getProcessorName(){
        return "Engineering Bay";
    }
    @Override
    public String processTask(ColonyTask task){
        EngineeringTask t = (EngineeringTask) task;
        return "Engineering Bay repaired [" +t.getName()+ "]" +" | Parts used: "+t.getRequiredParts()+" | Power used: "
                +t.getPowerRequired()+" | Time: "+t.getTimetoFix()+"s";
    }
    @Override
    public boolean canProcess(ColonyTask task){
        return "ENGINEERING".equals(task.getProcessorType());
    }

}
