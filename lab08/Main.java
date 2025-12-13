package lab08;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Створюємо студентів
        Student s1 = new Student("Ivan","Ivanov","A101",97.5);
        Student s2 = new Student("Petro","Petrenko","A102",89.0);
        Student s3 = new Student("Oksana","Shevchenko","A103",95.0);
        Student s4 = new Student("Maria","Koval","B201",100.0);
        Student s5 = new Student("Ivan","Ivanov","A101",97.5); // дубль за recordBook

        // Факультети
        Faculty f1 = new Faculty("Комп'ютерних наук");
        f1.addStudent(s1);
        f1.addStudent(s2);
        f1.addStudent(s3);

        Faculty f2 = new Faculty("Телекомунікацій");
        f2.addStudent(s4);
        f2.addStudent(s5); // додавання дубля нічого не змінить в HashSet

        // Інститут
        Institute inst = new Institute("Інститут Телекомунікацій");
        inst.addFaculty(f1);
        inst.addFaculty(f2);

        // Оновимо facultyMap, щоб відобразити студентів (бо в addFaculty ми кілька речей не синхронізували)
        inst.getFacultyMap().put(f1.getName(), f1.getStudents());
        inst.getFacultyMap().put(f2.getName(), f2.getStudents());

        // Також заповнимо studentByRecord в інституті:
        for (Student s : f1.getStudents()) inst.studentByRecord.put(s.getRecordBook(), s);
        for (Student s : f2.getStudents()) inst.studentByRecord.put(s.getRecordBook(), s);

        // ========== Задача 1: загальна кількість студентів (через Map або Set) ==========
        int total = 0;
        for (Set<Student> set : inst.getFacultyMap().values()) {
            total += set.size();
        }
        System.out.println("Загальна кількість студентів: " + total);

        // ========== Задача 2: факультет з найбільшою кількістю студентів (через Map) ==========
        String maxFacultyName = null;
        int maxCount = -1;
        for (Map.Entry<String, Set<Student>> e : inst.getFacultyMap().entrySet()) {
            int c = e.getValue().size();
            if (c > maxCount) {
                maxCount = c;
                maxFacultyName = e.getKey();
            }
        }
        System.out.println("Факультет з найбільшою кількістю студентів: " + maxFacultyName + " (" + maxCount + ")");

        // ========== Задача 3: студенти з балом 95..100 (for-each) ==========
        List<Student> best = new ArrayList<>();
        for (Set<Student> set : inst.getFacultyMap().values()) {
            for (Student s : set) {
                if (s.getAverageMark() >= 95 && s.getAverageMark() <= 100) best.add(s);
            }
        }
        System.out.println("Студенти з 95..100:");
        for (Student s : best) System.out.println(" - " + s);

        // ========== Приклад використання Map: пошук за номером залікової ==========
        Student found = inst.findByRecord("A103");
        System.out.println("Знайдений студент по A103: " + found);
    }
}
