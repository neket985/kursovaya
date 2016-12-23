import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.LinkedList;

public class MyTableModel implements TableModel {
    String[] columnNames = {"id", "Имя", "Фамилия", "Дата рождения", "Должность", "Оклад", "Квалификация"};
    LinkedList<Person> workers;
    int id = -1;

    MyTableModel(LinkedList<Person> workers){
        this.workers = workers;
    }
    public int getRowCount() {
        return workers.size();
    }

    public int getColumnCount() {
        return 7;
    }

    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 5:
                return Integer.class;
            default:
                return String.class;
        }
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex!=0){
            return true;
        }
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = workers.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return person.id;
            case 1:
                return person.firstname;
            case 2:
                return person.surname;
            case 3:
                return person.birthDate;
            case 4:
                return person.position;
            case 5:
                return person.salary;
            default:
                return person.kualification;
        }
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Person person = workers.get(rowIndex);
        switch (columnIndex) {
            case 1:
                person.firstname = aValue.toString();
                break;
            case 2:
                person.surname = aValue.toString();
                break;
            case 3:
                person.birthDate = java.sql.Date.valueOf(aValue.toString());
                break;
            case 4:
                person.position = aValue.toString();
                break;
            case 5:
                person.salary = Integer.parseInt(aValue.toString());
                break;
            default:
                person.kualification = aValue.toString();
        }
    }

    public void addTableModelListener(TableModelListener l) {

    }

    public void removeTableModelListener(TableModelListener l) {

    }
}
