package lab08;

import java.util.HashSet;
import java.util.Set;

public class Faculty {
    private String name;
    private Set<Student> students;

    public Faculty(String name) {
        this.name = name;
        this.students = new HashSet<>(); // множина, не допускає дублікатів
    }

    public String getName() { return name; }

    public boolean addStudent(Student s) {
        if (s == null) return false;
        return students.add(s); // додасть лише якщо такого recordBook ще нема
    }

    public Set<Student> getStudents() { return students; }

    public int getStudentCount() { return students.size(); }

    @Override
    public String toString() {
        return name + " (" + getStudentCount() + " students)";
    }

    // Якщо будете зберігати Faculty в HashSet, теж треба equals/hashCode (напр. по name)
}
