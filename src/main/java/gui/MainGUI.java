package main.java.gui;

import main.java.engine.SimulationEngine;
import main.java.resources.Resource;
import main.java.tasks.ColonyTask;

import javax.swing.*;
import java.awt.*;
public class MainGUI extends JFrame {
    private final SimulationEngine engine = new SimulationEngine();

    private final DefaultListModel<String> taskListModel = new DefaultListModel<>();
    private final JList<String> taskList = new JList<>(taskListModel);
    //zone 1
    private JPanel buildTaskQueuePanel(){
        JPanel panel = new JPanel(new BorderLayout(4,4));
        panel.setBorder(BorderFactory.createTitledBorder("Task Queue"));
        panel.add(new JScrollPane(taskList),BorderLayout.CENTER);
        JButton executeBtn = new JButton("Execute Next Task");
        executeBtn.addActionListener(e ->{
            String result = engine.executeNextTask();
            if(!taskListModel.isEmpty()) {
                taskListModel.remove(0);
            }
            log(result);
            refreshResourceDisplay();
        });
        panel.add(executeBtn,BorderLayout.SOUTH);
        return panel;
    }


}
