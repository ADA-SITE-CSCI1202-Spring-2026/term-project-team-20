package main.java.tasks;
import main.java.resources.Resource;
import java.util.*;

public class LifeSupportTask extends ColonyTask{
    private int oxygen;
    private int waterAmount;

    public LifeSupportTask(String name, int timeToFix, int requiredParts, int oxygen, int waterAmount) {
        super(name, timeToFix, requiredParts);
        this.oxygen = oxygen;
        this.waterAmount = waterAmount;
    }

    public int getOxygen() {
        return oxygen;
    }
    public int getWaterAmount() {
        return waterAmount;
    }

    @Override
    public Map<Resource, Integer> getResources() {
        return Map.of(Resource.SPARE_PARTS,requiredParts,Resource.OXYGEN, oxygen, Resource.WATER, waterAmount);
    }

    @Override
    public String getProcessorType() {
        return "LIFE_SUPPORT";
    }
}
