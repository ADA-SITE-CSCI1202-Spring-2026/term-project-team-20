package main.java.processors;
import main.java.tasks.ColonyTask;
public class EngineeringBay implements IProcessors {
    @Override
    public String getProcessorName(){
        return "ENGINEERING BAY";
    }
    @Override
    public String processTask(ColonyTask task){
        return "Engineering Bay processed: "+ task.getName();
    }
    @Override
    public boolean canProcess(ColonyTask task){
        return "ENGINEERING".equals(task.getProcessorType());
    }

}
