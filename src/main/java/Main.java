import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created by nikitos on 11.12.16.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        final String[] listComboBox = {"-", "id", "Имя", "Фамилия", "Дата рождения", "Должность", "Оклад", "Квалификация"};
        final LinkedList<Person> workers = new LinkedList<Person>();
//        final LinkedList<Person> workersShown = new LinkedList<Person>(workers);
        workers.add(new Person("", "", "1998-01-01", "", 0, ""));
        JFrame swg = new JFrame("workers");
        JButton add = new JButton("Добавить");
        JButton remove = new JButton("Удалить");
        final JComboBox list = new JComboBox(listComboBox);
        list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println(listComboBox[list.getSelectedIndex()]);
            }
        });
        swg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        swg.setSize(600, 400);

        TableModel model = new MyTableModel(workers);
        final JTable table = new JTable(model);
        table.setGridColor(Color.BLACK);

        add.addActionListener(new AddListener(workers, table));
        remove.addActionListener(new RemoveListener(workers, table));
        JPanel pannel = new JPanel();
        pannel.setBackground(new Color(117, 181, 255));
        pannel.add(new JLabel("Фильтр"));
        pannel.add(list);
        pannel.add(remove);
        pannel.add(add);
        pannel.add(table.getTableHeader());
        pannel.add(table);
        swg.add(pannel);
        swg.setVisible(true);
    }
}
