package main.java.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskFactory {
    public static List<ColonyTask> getTasks(){
        List<ColonyTask> tasks = new ArrayList<>(List.of(
                new LifeSupportTask("Oxygen leak",5,2,15,10),
                new LifeSupportTask("CO2 Scrubber Fail",4,3,10,5),
                new LifeSupportTask("Pressure Drop",6,4,20,15),
                new EngineeringTask("Solar Array Down",4,5,20),
                new EngineeringTask("Hull Breach",5,8,10),
                new EngineeringTask("Power Grid Failure",3,4,30),
                new ResearchTask("Soil Analysis",3,1,3),
                new ResearchTask("Telescope Calib,",4,2,2),
                new ResearchTask("Water Reclaim Test",5,2,4)

        ));
        return tasks;
    }
}
