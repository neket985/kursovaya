import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by nikitos on 11.12.16.
 */
public class AddListener implements ActionListener {
    HashMap<Integer, Person> workers;
    LinkedList<Person> workersShown;
    int id=-1;
    JTable table;
    public void actionPerformed(ActionEvent e) {
        Person newPerson = new Person(++id, "", "", "1900-01-01", "", 0, "");
        workers.put(newPerson.id, newPerson);
        workersShown.add(newPerson);
        table.revalidate();
    }
    AddListener (HashMap<Integer, Person> workers, LinkedList<Person> workersShown, JTable table){
        this.workers = workers;
        this.workersShown = workersShown;
        this.table = table;
    }
}
