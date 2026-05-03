package main.java.tasks;

import java.util.*;

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

    private static final int ENG_MAX_PARTS = 5;
    private static final int ENG_MIN_TIME = 5;
    private static final int ENG_MAX_TIME = 10;
    private static final int ENG_MIN_POWER = 5;
    private static final int ENG_MAX_POWER = 20;

    private static final int LS_MAX_PARTS = 4;
    private static final int LS_MIN_TIME = 5;
    private static final int LS_MAX_TIME = 10;
    private static final int LS_MIN_OXYGEN = 10;
    private static final int LS_MAX_OXYGEN = 20;
    private static final int LS_MIN_WATER = 5;
    private static final int LS_MAX_WATER = 15;

    private static final int RES_MAX_PARTS = 3;
    private static final int RES_MIN_TIME = 4;
    private static final int RES_MAX_TIME = 8;
    private static final int RES_MIN_RATIONS = 5;
    private static final int RES_MAX_RATIONS = 10;

    private final Random random = new Random();
    public ColonyTask generateRandomTask(){
        int type = random.nextInt(3);

        ColonyTask task;

        switch(type){
            case 0: {
                String name = ENGINEERING_NAMES[random.nextInt(ENGINEERING_NAMES.length)];
                int parts = random.nextInt(ENG_MAX_PARTS)+1;
                int time = random.nextInt(ENG_MAX_TIME)+ ENG_MIN_TIME;
                int power = random.nextInt(ENG_MAX_POWER)+ ENG_MIN_POWER;
                task = new EngineeringTask(name,time,parts,power);
                break;
            }
            case 1: {
                String name = LIFE_SUPPORT_NAMES[random.nextInt(LIFE_SUPPORT_NAMES.length)];
                int parts= random.nextInt(LS_MAX_PARTS)+1;
                int time = random.nextInt(LS_MAX_TIME)+ LS_MIN_TIME;
                int oxygen = random.nextInt(LS_MAX_OXYGEN)+ LS_MIN_OXYGEN;
                int water = random.nextInt(LS_MAX_WATER)+ LS_MIN_WATER;
                task = new LifeSupportTask(name,time,parts,oxygen,water);
                break;
            }
            default:{
                String name = RESEARCH_NAMES[random.nextInt(RESEARCH_NAMES.length)];
                int parts= random.nextInt(RES_MAX_PARTS)+1;
                int time = random.nextInt(RES_MAX_TIME)+ RES_MIN_TIME;
                int rations = random.nextInt(RES_MAX_RATIONS)+RES_MIN_RATIONS;
                task = new ResearchTask(name,time,parts,rations);
                break;
            }
        }

        return task;
    };

}
