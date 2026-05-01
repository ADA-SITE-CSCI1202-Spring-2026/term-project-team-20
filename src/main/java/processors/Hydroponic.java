package main.java.processors;


import main.java.tasks.ColonyTask;
import main.java.tasks.ResearchTask;

public class Hydroponic implements IProcessors {
    @Override
    public String getProcessorName() {
        return "Hydroponic Bay";
    }

    @Override
    public String processTask(ColonyTask task) {
        return "Hydroponics Bay completed: " + task.getName();
    }

    @Override
    public boolean canProcess(ColonyTask task) {
        return "RESEARCH".equals(task.getProcessorType());
    }

}
