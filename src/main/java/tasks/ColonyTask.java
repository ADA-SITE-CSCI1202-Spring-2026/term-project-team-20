package main.java.tasks;

public abstract class ColonyTask {
    protected String name;
    protected int time;
    protected int parts;

    public ColonyTask(String name, int time, int parts){
        this.name=name;
        this.time=time;
        this.parts=parts;
    }
    public String getName(){

        return name;
    }
    public int getTime(){
        return time;
    }
    public int getParts(){
        return parts;
    }
    public abstract void getProcessorType();
}
