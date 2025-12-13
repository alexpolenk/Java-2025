package lab07;

import java.util.ArrayList;
import java.util.List;

class Faculty {
    private String name;
    private List<Student> students;

    public Faculty(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }
}