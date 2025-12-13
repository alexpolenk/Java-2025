package lab08;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Institute {
    private String name;
    private Set<Faculty> faculties;
    // Map: назва факультету -> множина студентів (дублює, але зручно для демонстрації Map)
    private Map<String, Set<Student>> facultyMap;
    // Map: recordBook -> Student для швидкого пошуку
    public Map<String, Student> studentByRecord;

    public Institute(String name) {
        this.name = name;
        this.faculties = new HashSet<>();
        this.facultyMap = new HashMap<>();
        this.studentByRecord = new HashMap<>();
    }

    public void addFaculty(Faculty f) {
        if (f == null) return;
        faculties.add(f);
        facultyMap.putIfAbsent(f.getName(), f.getStudents());
    }

    // Додає студента в зазначений факультет (якщо факультет не існує — створює)
    public void addStudentToFaculty(String facultyName, Student s) {
        if (s == null || facultyName == null) return;
        // шукаємо факультет по назві
        Set<Student> set = facultyMap.get(facultyName);
        if (set == null) {
            set = new HashSet<>();
            facultyMap.put(facultyName, set);
            // також додаємо факультет-об'єкт у множину faculties (опціонально)
            faculties.add(new Faculty(facultyName)); // ця нова Faculty має свій пустий Set
        }
        set.add(s);
        studentByRecord.put(s.getRecordBook(), s);
    }

    public Set<Faculty> getFaculties() { return faculties; }
    public Map<String, Set<Student>> getFacultyMap() { return facultyMap; }
    public Student findByRecord(String recordBook) { return studentByRecord.get(recordBook); }
}
