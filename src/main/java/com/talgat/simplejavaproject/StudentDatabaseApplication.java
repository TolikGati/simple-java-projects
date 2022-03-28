package com.talgat.simplejavaproject;

import java.util.Scanner;

public class StudentDatabaseApplication {
    public static void main(String[] args) {
        System.out.println("Enter number of students to enroll: ");
        Scanner keyboard = new Scanner(System.in);
        int numberOfStudents = keyboard.nextInt();
        Student[] students = new Student[numberOfStudents];
        for ( int n = 0; n < numberOfStudents; n++) {
            students[n] = new Student();
            students[n].enrollCourse();
            students[n].payTuition();
            System.out.println(students[n].toString());

        }
    }
}
