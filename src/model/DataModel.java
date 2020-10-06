package model;

import javafx.stage.Stage;
import java.util.ArrayList;

public class DataModel {
    // Das Model darf keine Referenz auf eine View oder einen Controller haben!
    private ArrayList<Person> list;

    public DataModel() {
        this.list = new ArrayList<>();
    }

    public void addPerson(Person person)
    {
        list.add(person);
    }

    public ArrayList<Person> getList() {
        return list;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        for (Person person:list) {
            buffer.append(person.toString());
            buffer.append("\n");
        }

        return  buffer.toString();
    }
}
