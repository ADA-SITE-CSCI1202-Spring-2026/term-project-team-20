package main.java.io;

import main.java.resources.ResourceManager;
import main.java.resources.Resource;
import main.java.tasks.ColonyTask;
import main.java.tasks.ResearchTask;
import main.java.tasks.EngineeringTask;
import main.java.tasks.LifeSupportTask;

import java.io.*;
import java.util.*;


public class SaveLoadManager {

    private static final String SAVE_FILE = "ares_save.txt";

    public static void save(ResourceManager rm, Queue<ColonyTask> queue) throws IOException
    {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(SAVE_FILE))))
        {
            pw.println("CREDITS," + rm.getCredits());

            for (Resource r: Resource.values())
            {
                if (r != Resource.CREDITS)
                {
                    pw.println("RESOURCE," + r.name() + "," + rm.getAmount(r));
                }
            }

            for (ColonyTask task : queue)
            {
                String base = "TASK," + task.getProcessorType() + "," + task.getName()
                        + "," + task.getRequiredParts() + "," + task.getTimeToFix();

                if (task instanceof LifeSupportTask lst)
                {
                    pw.println(base + "," + lst.getOxygen() + "," + lst.getWaterAmount());
                } else if(task instanceof EngineeringTask et)
                {
                    pw.println(base + "," + et.getPowerRequired());
                } else if (task instanceof ResearchTask rt)
                {
                    pw.println(base + "," + rt.getRationsRequired());

                }
            }
        }

    }


    public static void load(ResourceManager rm, Queue<ColonyTask> queue) throws IOException
    {
        queue.clear();

        try(BufferedReader br = new BufferedReader(new FileReader(SAVE_FILE)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split(",");
                switch (parts[0])
                {
                    case "CREDITS":
                        rm.setCredits(Integer.parseInt(parts[1]));
                        break;
                    case "RESOURCE":
                        rm.setResource(Resource.valueOf(parts[1]), Integer.parseInt(parts[2]));
                        break;
                    case "TASK":
                        // parts[1]=type, parts[2]=name, parts[3]=requiredParts, parts[4]=timeToFix
                        // parts[5]= unique value, parts[6]= unique value (LIFE_SUPPORT only)

                        String type = parts[1];
                        String name =  parts[2];
                        int requiredParts = Integer.parseInt(parts[3]);
                        int timeToFix = Integer.parseInt(parts[4]);

                        switch (type)
                        {
                            case "LIFE_SUPPORT":
                                int oxygen = Integer.parseInt(parts[5]);
                                int water = Integer.parseInt(parts[6]);
                                queue.add(new LifeSupportTask(name,timeToFix, requiredParts,oxygen,water));
                                break;
                            case "ENGINEERING":
                                int power = Integer.parseInt(parts[5]);
                                queue.add(new EngineeringTask(name,timeToFix,requiredParts,power));
                                break;

                            case "RESEARCH":
                                int rations =  Integer.parseInt(parts[5]);
                                queue.add(new ResearchTask(name,timeToFix,requiredParts,rations));

                                break;
                        }
                        break;

                }
            }
        }
    }
}
