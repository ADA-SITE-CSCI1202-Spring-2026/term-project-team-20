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
        LifeSupportTask t = (LifeSupportTask) task;

        return "Medical Ward resolved [" + t.getName() + "]"
                + " | O2 used: " + t.getOxygen()
                + " | Water used: " + t.getWaterAmount()
                + " | Parts used: " + t.getRequiredParts()
                + " | Time: " + t.getTimetoFix() + "s";
    }

    @Override
    public boolean canProcess(ColonyTask task)
    {
        return "LIFE_SUPPORT".equals(task.getProcessorType());
    }
}
