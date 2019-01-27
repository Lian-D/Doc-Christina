package function;

import java.util.ArrayList;

public class PriorityList {
    public ArrayList<Alert> priorityAlerts;
    public ArrayList<Alert> alerts;

    //Return a list of alerts in the order of priority
    public ArrayList<Alert> getAlerts() {
        ArrayList<Alert> finalList = new ArrayList<>();
        finalList.addAll(priorityAlerts);
        finalList.addAll(alerts);
        return  finalList;
    }
}
