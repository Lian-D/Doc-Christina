package data;


public class Alert {
    public String urgency;
    public Patient patient;
    public Room room;
    public Employee employee;


    public String printAlert(){
        String alert = urgency+" "+patient.name+" "+room.room+" "+"by"+employee.name;
        System.out.println(alert);
        return alert;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
