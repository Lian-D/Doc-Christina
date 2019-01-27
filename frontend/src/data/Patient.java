package data;

import java.util.ArrayList;

public class Patient {
    public String name;
    public String room;
    public ArrayList<String> concerns;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getConcerns() {
        return concerns;
    }

    public void setConcerns(ArrayList<String> concerns) {
        this.concerns = concerns;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
