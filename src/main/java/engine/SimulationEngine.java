package main.java.engine;

import main.java.processors.*;
import main.java.resources.*;
import main.java.tasks.ColonyTask;
import main.java.tasks.TaskGenerator;
import main.java.io.SaveLoadManager;

import java.io.IOException;
import java.util.*;

public class SimulationEngine {
    private final Queue<ColonyTask> taskQueue;
    private final ResourceManager resourceManager;
    private final List<IProcessor> processors;
    private final TaskGenerator taskGenerator;

    public SimulationEngine()
    {
        taskQueue = new LinkedList<>();
        resourceManager = new ResourceManager();
        taskGenerator = new TaskGenerator();

        processors = new ArrayList<>();
        processors.add(new EngineeringBay());
        processors.add(new MedicalWard());
        processors.add(new Hydroponics());
    }

    public ColonyTask generateTask()
    {
        ColonyTask task = taskGenerator.generateRandomTask();
        taskQueue.add(task);
        return task;
    }

    public String executeNextTask()
    {
        ColonyTask task = taskQueue.peek();

        if (task == null)
        {
            return "No tasks in queue!";
        }

        if (!resourceManager.hasEnoughForTask(task.getResources()))
        {
            StringBuilder missing = new StringBuilder("ERROR: Cannot fix: " + task.getName() + " - Missing: ");
            task.getResources().forEach((r, amt) -> {
                if (!resourceManager.hasEnough(r, amt))
                    missing.append(r.name()).append(" (need ").append(amt)
                            .append(", have ").append(resourceManager.getAmount(r)).append(") ");
            });
            return missing.toString().trim();
        }

        taskQueue.poll();

        for (IProcessor processor : processors)
        {
            if (processor.canProcess(task))
            {
                resourceManager.deductAll(task.getResources());
                resourceManager.addCredits(100);
                return processor.processTask(task);
            }
        }

        return "ERROR: No processor found for task: " + task.getName();
    }

    public String restockResource(Resource resource)
    {
        if (resourceManager.getCredits() < 100)
        {
            return "ERROR: Not enough credits!";
        }

        resourceManager.deductCredits(100);
        resourceManager.restock(resource,20);
        return "Bought 20 units of " + resource.name() + " for 100 credits!";
    }

    public String saveState()
    {
        try {
            SaveLoadManager.save(resourceManager, taskQueue);
            return "State saved successfully!";
        } catch (IOException e) {
            return "ERROR: Save failed: " + e.getMessage();
        }
    }

    public String loadState()
    {
        try {
            SaveLoadManager.load(resourceManager, taskQueue);
            return "State loaded successfully!";
        } catch (IOException e) {
            return "ERROR: Load failed: " + e.getMessage();
        }
    }

    public int getCredits()
    {
        return resourceManager.getCredits();
    }

    public int getResourceAmount(Resource resource)
    {
        return resourceManager.getAmount(resource);
    }

    public Queue<ColonyTask> getTaskQueue()
    {
        return taskQueue;
    }
}
