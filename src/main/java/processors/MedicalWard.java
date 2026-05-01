package main.java.processors;

import main.java.tasks.ColonyTask;
import main.java.tasks.LifeSupportTask;

public class MedicalWard implements IProcessors {
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
