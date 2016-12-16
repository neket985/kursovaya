import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created by nikitos on 11.12.16.
 */
public class AddListener implements ActionListener {
    LinkedList<Person> workers;
    JTable table;
    public void actionPerformed(ActionEvent e) {
        workers.add(new Person("", "", "1900-01-01", "", 0, ""));
        table.revalidate();
    }
    AddListener (LinkedList<Person> workers, JTable table){
        this.workers = workers;
        this.table = table;
    }
}
