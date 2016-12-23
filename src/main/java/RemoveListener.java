import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;

public class RemoveListener implements ActionListener {
    HashMap<Integer, Person> workers;
    LinkedList<Person> workersShown;
    JTable table;
    public void actionPerformed(ActionEvent e) {
        int i = table.getSelectedRow();
        if(i!=-1) {
            workers.remove(workersShown.get(i).id);
            workersShown.remove(i);
            table.revalidate();
        }
    }
    RemoveListener (HashMap<Integer, Person> workers, LinkedList<Person> workersShown, JTable table){
        this.workers = workers;
        this.workersShown = workersShown;
        this.table = table;
    }
}
