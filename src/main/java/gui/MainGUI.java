package main.java.gui;

import main.java.engine.SimulationEngine;
import main.java.resources.Resource;
import main.java.tasks.ColonyTask;

import javax.swing.*;
import java.awt.*;
public class MainGUI extends JFrame {
    private final SimulationEngine engine = new SimulationEngine();

    // zone 1 - task queue
    private final DefaultListModel<String> taskListModel = new DefaultListModel<>();
    private final JList<String> taskList = new JList<>(taskListModel);

    // zone 2  - resources - colony vitals
    private final JLabel creditsLabel = new JLabel();
    private final JLabel oxygenLabel = new JLabel();
    private final JLabel waterLabel = new JLabel();
    private final JLabel partsLabel = new JLabel();
    private final JLabel powerLabel = new JLabel();
    private final JLabel rationsLabel = new JLabel();

    // zone 3 - supply chain
    private final JComboBox<Resource> resourceDropdown = new JComboBox<>();


    // zone 4 - system log
    // yazilacaq


    // public MainGUI()
    // yazilacaq


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

    // zone 2 - colony vitals
    private JPanel buildResourcePanel()
    {
        JPanel panel = new JPanel(new GridLayout(7,1,4,4));
        panel.setBorder(BorderFactory.createTitledBorder("Colony Vitals"));

        panel.add(creditsLabel);
        panel.add(partsLabel);
        panel.add(oxygenLabel);
        panel.add(waterLabel);
        panel.add(rationsLabel);
        panel.add(powerLabel);

        return panel;
    }
    //zone 3 - supply chain
    private JPanel buildSupplyChainPanel(){
        JPanel panel = new JPanel(new BorderLayout(4,4));
        panel.setBorder(BorderFactory.createTitledBorder("Cargo Replicator"));

        for(Resource r: Resource.values()){
            if(r != Resource.CREDITS){
                resourceDropdown.addItem(r);
            }
        }
        JButton restockBtn = new JButton("Synthesize");
        restockBtn.addActionListener(e -> {
            Resource selected =(Resource) resourceDropdown.getSelectedItem();
            String result = engine.restockResource(selected);
            log(result);
            refreshResourceDisplay();
        });
        panel.add(resourceDropdown,BorderLayout.CENTER);
        panel.add(restockBtn,BorderLayout.SOUTH);
        return panel;
    }



}
