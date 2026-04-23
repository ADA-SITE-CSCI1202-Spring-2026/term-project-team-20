package main.java.processors;
import main.java.tasks.ColonyTask;
public interface IProcessors {
    String getProcessorName();
    String processTask(ColonyTask task);
    boolean canProcess(ColonyTask task);


}
