package main.java.processors;

import main.java.tasks.ColonyTask;

public class MedicalWard implements IProcessor {
    @Override
    public String getProcessorName()
    {
        return "Medical Ward";
    }

    @Override
    public String processTask(ColonyTask task)
    {
        return "Medical Ward resolved: " + task.getName();
    }

    @Override
    public boolean canProcess(ColonyTask task)
    {
        return "LIFE_SUPPORT".equals(task.getProcessorType());
    }
}
