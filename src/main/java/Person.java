import java.sql.Date;

public class Person {
    int id=0;
    String firstname;
    String surname;
    Date birthDate;
    String position;
    Integer salary;
    String kualification;

    Person(int id, String firstname, String surname, String birthDate, String position, int salary, String kualification) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.birthDate = java.sql.Date.valueOf(birthDate);
        this.position = position;
        this.salary = salary;
        this.kualification = kualification;
    }
}
