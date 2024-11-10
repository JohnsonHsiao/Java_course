package edu.neu.mgen;

public class Main {
    public static void main(String[] args) {
        EngClass engClass = new EngClass();

        // Creating student instances
        Student student1 = new Student("001", "Alice", "Smith");
        Student student2 = new Student("002", "Bob", "Johnson");
        Student student3 = new Student("003", "Charlie", "Brown");

        // Adding students
        engClass.addStudent(student1);
        engClass.addStudent(student2);
        engClass.addStudent(student3);

        // Displaying all students
        engClass.displayStudents();

        // Deleting a student by ID
        engClass.deleteStudent("002");

        // Displaying students after deletion
        engClass.displayStudents();
    }
}
