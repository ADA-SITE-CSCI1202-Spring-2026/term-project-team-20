package main.java.processors;

import main.java.tasks.ColonyTask;

public class Hydroponics implements IProcessor {
    @Override
    public String processTask(ColonyTask task) {
        return "Hydroponics Bay completed: " + task.getName();
    }

    @Override
    public boolean canProcess(ColonyTask task) {
        return "RESEARCH".equals(task.getProcessorType());
    }

}
