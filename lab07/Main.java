package lab07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ------- Створення студентів -------
        Student s1 = new Student("Ivan", "Ivanov", "A101", 97.5);
        Student s2 = new Student("Petro", "Petrenko", "A102", 89.0);
        Student s3 = new Student("Oksana", "Shevchenko", "A103", 95.0);
        Student s4 = new Student("Maria", "Koval", "B201", 100.0);

        // ------- Створення факультетів -------
        Faculty f1 = new Faculty("Комп'ютерних наук");
        f1.addStudent(s1);
        f1.addStudent(s2);
        f1.addStudent(s3);

        Faculty f2 = new Faculty("Телекомунікацій");
        f2.addStudent(s4);

        // ------- Створення інституту -------
        Institute inst = new Institute("Інститут Телекомунікацій");
        inst.addFaculty(f1);
        inst.addFaculty(f2);

        // ========== Задача 1: знайти загальну кількість студентів ==========
        // Вимога: використати нетипізований iterator

        int totalStudents = 0;
        Iterator facIter = inst.getFaculties().iterator(); // <--- НЕтипізований

        while (facIter.hasNext()) {
            Faculty f = (Faculty) facIter.next();
            Iterator studIter = f.getStudents().iterator(); // <--- також нетипізований
            while (studIter.hasNext()) {
                studIter.next();
                totalStudents++;
            }
        }

        System.out.println("1) Загальна кількість студентів: " + totalStudents);

        // ========== Задача 2: факультет з найбільшою кількістю студентів ==========
        // Вимога: типізований ітератор

        Faculty maxFaculty = null;
        int maxCount = -1;

        Iterator<Faculty> it = inst.getFaculties().iterator(); // типізований

        while (it.hasNext()) {
            Faculty f = it.next();
            int count = f.getStudents().size();
            if (count > maxCount) {
                maxCount = count;
                maxFaculty = f;
            }
        }

        System.out.println("2) Факультет з найбільшою кількістю студентів: " + maxFaculty.getName());

        // ========== Задача 3: список студентів з балом 95..100 ==========
        // Вимога: використати цикл for-each

        List<Student> bestStudents = new ArrayList<>();

        for (Faculty f : inst.getFaculties()) {
            for (Student s : f.getStudents()) {
                if (s.getAverageMark() >= 95 && s.getAverageMark() <= 100) {
                    bestStudents.add(s);
                }
            }
        }

        System.out.println("3) Студенти з балом 95..100:");
        for (Student s : bestStudents) {
            System.out.println("   - " + s);
        }
    }
}