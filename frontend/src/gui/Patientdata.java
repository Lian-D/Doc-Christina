package gui;

import function.FileUpdateCheck;
import function.Filereader;
import function.PriorityList;
import function.StringParse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Patientdata implements Initializable {
    @FXML
    ListView listView;
    @FXML
    int items;
    ArrayList<String> priority;
    ArrayList<String> norm;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //The Following is for the demo, please ignore this
        PriorityList priorityList = new PriorityList();
        priority = new ArrayList<>();
        norm = new ArrayList<>();

        priority.add("Urgent Room 404 needs 5 Nurses");
        priority.add("Urgent Room 105 needs a heart surgeon");
        norm.add("room 111 needs water");
        norm.add("room 212 needs a book to read");
        priority.add("Urgent Room 105 needs a AED");
        priorityList.priorityAlerts = priority;
        priorityList.alerts = norm;
        //End of demo stuff

        //Puts list stuff onto the listview
        ArrayList<String> priorities = priorityList.getAlerts();
        for (String s: priorities){
            items++;
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
                StringParse sp = new StringParse();
                if (value) {
                    Filereader filereader = new Filereader();
                    try {
                        sp.transcribedData = filereader.readFile("speechdata.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //Create new list view
                    String stored = sp.parseData();
                    //New PriorityList
                    PriorityList pl = new PriorityList();
                    pl.priorityAlerts = priority;
                    pl.alerts = norm;
                    pl.filterStringForList(stored);
                    int item = listView.getItems().size();
                    for (int i = 0; i<item; i++){
                        System.out.println(listView.getItems().size());
                        listView.getItems().remove(0);
                    }
                    ArrayList<String> data = pl.getAlerts();
                    for (String s: data){
                        listView.getItems().add(s);
                    }
                }
            }
        };

        new javax.swing.Timer(delay, taskPerformer).start();

    }
}
