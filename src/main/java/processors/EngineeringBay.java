package main.java.processors;
import main.java.tasks.ColonyTask;

public class EngineeringBay implements IProcessor {
    @Override
    public String processTask(ColonyTask task){
        return "Engineering Bay repaired: " +task.getName();
    }
    @Override
    public boolean canProcess(ColonyTask task){
        return "ENGINEERING".equals(task.getProcessorType());
    }

}
