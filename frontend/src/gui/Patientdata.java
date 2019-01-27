package gui;

import function.FileUpdateCheck;
import function.PriorityList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Patientdata implements Initializable {
    @FXML
    ListView listView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //The Following is for the demo, please ignore this
        PriorityList priorityList = new PriorityList();
        ArrayList<String> priority = new ArrayList<>();
        ArrayList<String> norm = new ArrayList<>();
        priority.add("Urgent Room 404 needs 5 Nurses");
        priority.add("Urgent Room 105 needs a heart surgeon");
        norm.add("room 111 needs water");
        norm.add("room 212 needs a book to read");
        priority.add("Urgent Room 105 needs a AED");
        priorityList.priorityAlerts = priority;
        priorityList.alerts = norm;
        //I will make this stuff update soon
        ArrayList<String> priorities = priorityList.getAlerts();
        for (String s: priorities){
            listView.getItems().add(s);
        }
        File file = new File("speechdata.txt");
        FileUpdateCheck fuc = new FileUpdateCheck();
        fuc.fileUpdate(file);
        //This is how we test for if our files have updated
        int delay = 2500; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Checking For Updates");
                boolean value = fuc.isFileUpdated(file);
                System.out.println(value);
//                value = fuc.isFileUpdated(file);
//                System.out.println(value);
//                fuc.timeStamp = 550000;
//                value = fuc.isFileUpdated(file);
//                System.out.println(value);
            }
        };
        new javax.swing.Timer(delay, taskPerformer).start();

    }
}
