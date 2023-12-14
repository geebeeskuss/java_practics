package Task2;

public class LabClassDriver {
    public static void main(String[] args) {
        Student[] students = new Student[7];
        students[0] = new Student("Альбина", 95);
        students[1] = new Student("Анна", 43);
        students[2] = new Student("Ева", 23);
        students[3] = new Student("Оля", 78);
        students[4] = new Student("Макка", 100);
        students[5] = new Student("Вита", 45);
        students[6] = new Student("Алина", 69);
        new LabClassUI(students);
    }
}
