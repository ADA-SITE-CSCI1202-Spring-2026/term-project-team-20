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
        return "Engineering Bay repaired: " +task.getName();
    }
    @Override
    public boolean canProcess(ColonyTask task){
        return "ENGINEERING".equals(task.getProcessorType());
    }

}
