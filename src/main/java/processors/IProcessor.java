package main.java.processors;
import main.java.tasks.ColonyTask;
public interface IProcessor {
    String processTask(ColonyTask task);
    boolean canProcess(ColonyTask task);
}
