package data;

import java.util.Objects;

public class Room {
    public String room;
    public Patient patient;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room1 = (Room) o;
        return Objects.equals(room, room1.room) &&
                Objects.equals(patient, room1.patient);
    }

    @Override
    public int hashCode() {

        return Objects.hash(room, patient);
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
