package lab08;

// Student.java
import java.util.Objects;

public class Student {
    private String name;
    private String surname;
    private String recordBook; // унікальний ідентифікатор
    private double averageMark;

    public Student(String name, String surname, String recordBook, double averageMark) {
        this.name = name;
        this.surname = surname;
        this.recordBook = recordBook;
        this.averageMark = averageMark;
    }

    public String getRecordBook() { return recordBook; }
    public double getAverageMark() { return averageMark; }
    public String getName() { return name; }
    public String getSurname() { return surname; }

    // Важливо: equals/hashCode для коректної роботи в HashSet/HashMap
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return Objects.equals(recordBook, s.recordBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordBook);
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + recordBook + ", " + averageMark + ")";
    }
}
