package main.java.tasks;

import java.util.*;
import main.java.tasks.*;

public class TaskGenerator {
    private static final String[] ENGINEERING_NAMES ={
            "Hull Breach", "Solar Array Down","Power Grid Failure","Reactor Coolant Leak",
            "Engine Thruster Malfunction"
    };
    private static final String[] LIFE_SUPPORT_NAMES={"Air Lock Seal Breach","Oxygen Leak","Pressure Drop",
            "CO2 Scrubber Fail","Water Recycler Breakdown"
    };
    private static final String[] RESEARCH_NAMES= {"Soil Analysis","Water Claim Test","Geological Survey",
            "Microbial Culture Study","Atmospheric Data Collection"
    };

    private final Random random = new Random();
//    private final Queue <ColonyTask> taskQueue; // taskin hara getdiyini
//    private Runnable onTaskGenerated; // gui-e xeberdarliq edir

//    public TaskGenerator(Queue<ColonyTask> taskQueue) {
//        this.taskQueue = taskQueue;
//    }
//    public void setOnTaskGenerated(Runnable callback){
//        this.onTaskGenerated= callback;
//    }
    public ColonyTask generateRandomTask(){
        int type = random.nextInt(3);

        ColonyTask task;

        switch(type){
            case 0: {
                String name = ENGINEERING_NAMES[random.nextInt(ENGINEERING_NAMES.length)];
                int parts = random.nextInt(5)+1;
                int time = random.nextInt(10)+5;
                int power = random.nextInt(20)+5;
                task = new EngineeringTask(name,time,parts,power);
                break;
            }
            case 1: {
                String name = LIFE_SUPPORT_NAMES[random.nextInt(LIFE_SUPPORT_NAMES.length)];
                int parts= random.nextInt(4)+1;
                int time = random.nextInt(10)+5;
                int oxygen = random.nextInt(20)+10;
                int water = random.nextInt(15)+5;
                task = new LifeSupportTask(name,time,parts,oxygen,water);
                break;
            }
            default:{
                String name = RESEARCH_NAMES[random.nextInt(RESEARCH_NAMES.length)];
                int parts= random.nextInt(3)+1;
                int time = random.nextInt(8)+4;
                int rations = random.nextInt(10)+5;
                task = new ResearchTask(name,time,parts,rations);
                break;
            }
        }

//        taskQueue.add(task);
        return task;
    };

}
