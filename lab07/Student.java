package lab07;



class Student {
    private String name;
    private String surname;
    private String recordBook;
    private double averageMark;

    public Student(String name, String surname, String recordBook, double averageMark) {
        this.name = name;
        this.surname = surname;
        this.recordBook = recordBook;
        this.averageMark = averageMark;
    }

    public double getAverageMark() {
        return averageMark;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", № " + recordBook + ", середній бал: " + averageMark;
    }
}