package edu.neu.mgen;

public class Student {
    private String studentID;
    private String firstName;
    private String lastName;

    // Constructor
    public Student(String studentID, String firstName, String lastName) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters
    public String getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // toString method for easy printing
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + firstName + " " + lastName;
    }
}
