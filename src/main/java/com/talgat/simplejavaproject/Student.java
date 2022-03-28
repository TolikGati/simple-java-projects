package com.talgat.simplejavaproject;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentId;
    private int tuitionBalance = 0;
    private static int costOrCourse = 700;
    private String courses = "";
    private static int id = 1001;
    // Prompt user to enter first name, last name, grade year;

    public Student() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        this.firstName = keyboard.nextLine();

        System.out.println("Enter student last name: ");
        this.lastName = keyboard.nextLine();

        System.out.println("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student grade level: ");
        this.gradeYear = keyboard.nextInt();
        setStudentId();
        System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentId);

    }

    // Generate an user Id(grade year + student Id);
    private void setStudentId() {
        id++;
        this.studentId = gradeYear + "" + id;

    }

    //Enroll in courses;
    public void enrollCourse() {
        do {

            System.out.println("Enter course to enroll (Q to quit): ");
            Scanner keyboard = new Scanner(System.in);
            String course = keyboard.nextLine();

            if (!course.equals("Q")) {
                courses = courses + "\n  " + course;
                tuitionBalance = tuitionBalance + costOrCourse;
            } else {
                break;
            }

        } while (1 != 0);


        System.out.println("Enrolled in: " + courses);
        System.out.println("Tuition balance is: $" + tuitionBalance);

    }
    public void viewBalance(){
        System.out.println("Your balance is: $" + tuitionBalance);
    }
    // Pay tuition;
    public void payTuition(){
        viewBalance();
        System.out.println("Enter your payment: $");
        Scanner keyboard = new Scanner(System.in);
         int payment  = keyboard.nextInt();
        tuitionBalance = tuitionBalance  - payment;
        System.out.println("Thank you for your payment of: $" + payment);
        viewBalance();

    }
    // Show information;
    public String toString(){
        return "Name: " + firstName +" " + lastName +
                "\nCourses enrolled: " + courses +
                "\nGrade year: " + gradeYear +
                "\nStudentId: " + studentId +
                "\nBalance: $" + tuitionBalance;

    }


}