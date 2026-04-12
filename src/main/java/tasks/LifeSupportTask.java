package main.java.tasks;

public class LifeSupportTask extends ColonyTask{
    private int oxygen;
    private int spareParts;

    public LifeSupportTask(String name, int time, int parts, int oxygen, int spareParts) {
        super(name, time, parts);
        this.oxygen = oxygen;
        this.spareParts = spareParts;
    }

    public int getOxygen() {
        return oxygen;
    }
    public int getSpareParts() {
        return spareParts;
    }

    @Override
    public void getProcessorType() {
    }


}
