import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created by nikitos on 15.12.16.
 */
public class RemoveListener implements ActionListener {
    LinkedList<Person> workers;
    JTable table;
    public void actionPerformed(ActionEvent e) {
        int i = table.getSelectedRow();
        if(i!=-1) {
            workers.remove(i);
            table.revalidate();
        }
    }
    RemoveListener (LinkedList<Person> workers, JTable table){
        this.workers = workers;
        this.table = table;
    }
}
