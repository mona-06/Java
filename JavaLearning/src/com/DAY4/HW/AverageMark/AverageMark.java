package com.DAY4.HW.AverageMark;

class Student {
    private int marks;

    // Setter
    public void setMarks(int marks) {
        this.marks = marks;
    }

    // Getter
    public int getMarks() {
        return marks;
    }
}

public class AverageMark {
    public static void main(String[] args) {
        // Create an array of 5 students
        Student[] students = new Student[5];

        // Marks for 5 students
        int[] marksArray = {85, 90, 75, 80, 95};

        // Store marks in student objects
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].setMarks(marksArray[i]);
        }

        // Calculate total and average
        int total = 0;
        for (Student s : students) {
            total += s.getMarks();
        }

        double average = (double) total / students.length;

        // Display each student's marks
        System.out.println("Marks of Students:");
        for (int i = 0; i < students.length; i++) {
            System.out.println("Student " + (i + 1) + ": " + students[i].getMarks());
        }

        // Display average
        System.out.println("\nAverage Marks = " + average);
    }
}
