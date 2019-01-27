package function;

import jdk.internal.util.xml.impl.Input;

import java.util.ArrayList;

public class PriorityList {
    public ArrayList<String> priorityAlerts;
    public ArrayList<String> alerts;

    //Return a list of alerts in the order of priority
    public ArrayList<String> getAlerts() {
        ArrayList<String> finalList = new ArrayList<>();
        finalList.addAll(priorityAlerts);
        finalList.addAll(alerts);
        return  finalList;
    }
    //checks for priority and places the alerts to the respective priorities
    public void filterStringForList(String input){
        if (input.toLowerCase().contains("urgent")){
            priorityAlerts.add(input);
        }
        else{
            alerts.add(input);
        }
    }
}
