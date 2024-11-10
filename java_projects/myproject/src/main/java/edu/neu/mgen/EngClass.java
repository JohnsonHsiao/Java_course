package edu.neu.mgen;

import java.util.ArrayList;
import java.util.List;

public class EngClass {
    private List<Student> students;

    // Constructor
    public EngClass() {
        this.students = new ArrayList<>();
    }

    // Method to add a student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added: " + student);
    }

    // Method to delete a student by ID
    public void deleteStudent(String studentID) {
        students.removeIf(student -> student.getStudentID().equals(studentID));
        System.out.println("Student with ID " + studentID + " has been removed.");
    }

    // Method to display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the class.");
        } else {
            System.out.println("List of students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}