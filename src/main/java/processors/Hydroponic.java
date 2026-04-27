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
        ResearchTask t = (ResearchTask) task;
        return "Hydroponics Bay completed [" + t.getName() + "]"
                + " | Rations used: " + t.getRationsRequired()
                + " | Parts used: " + t.getRequiredParts()
                + " | Time: " + t.getTimeToFix() + "s";
    }

    @Override
    public boolean canProcess(ColonyTask task) {
        return "RESEARCH".equals(task.getProcessorType());
    }

}
