import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    static final String[] listComboBox = {"-", "id", "Имя", "Фамилия", "Дата рождения", "Должность", "Оклад", "Квалификация"};

    public static void main(String[] args) throws InterruptedException {
        final HashMap<Integer, Person> workers = new HashMap<Integer, Person>();
        final LinkedList<Person> workersShown = new LinkedList<Person>();
        JFrame swg = new JFrame("workers");
        JButton addBTN = new JButton("Добавить");
        JButton removeBTN = new JButton("Удалить");
        JButton filterBTN = new JButton("Фильтр");
        final JComboBox comboBox = new JComboBox(listComboBox);

        final JTextField filter = new JTextField();
        filter.setPreferredSize(new Dimension(200, 20));

        TableModel model = new MyTableModel(workersShown);
        final JTable table = new JTable(model);
        table.setGridColor(Color.BLACK);

        filter.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    filterFun(workers, workersShown, comboBox, filter, table);
                }
            }
        });

        filterBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filterFun(workers, workersShown, comboBox, filter, table);
            }
        });

        addBTN.addActionListener(new AddListener(workers, workersShown, table));
        removeBTN.addActionListener(new RemoveListener(workers, workersShown, table));

        JPanel pannel = new JPanel();
        pannel.setBackground(new Color(117, 181, 255));
        pannel.add(new JLabel("Фильтр"));
        pannel.add(comboBox);
        pannel.add(removeBTN);
        pannel.add(addBTN);
        pannel.add(filter);
        pannel.add(filterBTN);
        pannel.add(table.getTableHeader());
        pannel.add(table);

        swg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        swg.setSize(600, 400);
        swg.add(pannel);
        swg.setVisible(true);
    }

    static void filterFun(HashMap<Integer, Person> workers, LinkedList<Person> workersShown, JComboBox list, JTextField filter, JTable table) {
        if (workersShown.size() != workers.values().size()) {
            while(workersShown.size()!=0) {
                workersShown.remove();
            }
            Iterator<Person> itr = workers.values().iterator();
            Person checkPerson;
            while (itr.hasNext()) {
                checkPerson=itr.next();
                switch (list.getSelectedIndex()) {
                    case 0:
                        workersShown.add(checkPerson);
                        break;
                    case 1:
                        if (("" + checkPerson.id).equals(filter.getText())) {
                            workersShown.add(checkPerson);
                        }
                        break;
                    case 2:
                        if (checkPerson.firstname.equals(filter.getText())) {
                            workersShown.add(checkPerson);
                        }
                        break;
                    case 3:
                        if (checkPerson.surname.equals(filter.getText())) {
                            workersShown.add(checkPerson);
                        }
                        break;
                    case 4:
                        if (checkPerson.birthDate.toString().equals(filter.getText())) {
                            workersShown.add(checkPerson);
                        }
                        break;
                    case 5:
                        if (checkPerson.position.equals(filter.getText())) {
                            workersShown.add(checkPerson);
                        }
                        break;
                    case 6:
                        if (checkPerson.salary.toString().equals(filter.getText())) {
                            workersShown.add(checkPerson);
                        }
                        break;
                    case 7:
                        if (checkPerson.kualification.equals(filter.getText())) {
                            workersShown.add(checkPerson);
                        }
                        break;
                }
            }
        } else {
            Person checkPerson;
            for (int i=0;i<workersShown.size();++i) {
                checkPerson = workersShown.get(i);
                switch (list.getSelectedIndex()) {
                    case 1:
                        if (!("" + checkPerson.id).equals(filter.getText())) {
                            workersShown.remove(checkPerson);
                            --i;
                        }
                        break;
                    case 2:
                        if (!checkPerson.firstname.equals(filter.getText())) {
                            workersShown.remove(checkPerson);
                            --i;
                        }
                        break;
                    case 3:
                        if (!checkPerson.surname.equals(filter.getText())) {
                            workersShown.remove(checkPerson);
                            --i;
                        }
                        break;
                    case 4:
                        if (!checkPerson.birthDate.toString().equals(filter.getText())) {
                            workersShown.remove(checkPerson);
                            --i;
                        }
                        break;
                    case 5:
                        if (!checkPerson.position.equals(filter.getText())) {
                            workersShown.remove(checkPerson);
                            --i;
                        }
                        break;
                    case 6:
                        if (!checkPerson.salary.toString().equals(filter.getText())) {
                            workersShown.remove(checkPerson);
                            --i;
                        }
                        break;
                    case 7:
                        if (!checkPerson.kualification.equals(filter.getText())) {
                            workersShown.remove(checkPerson);
                            --i;
                        }
                        break;
                }
            }
        }
        table.revalidate();
    }
}
