package com.talgat.simplejavaproject;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private int mailboxCapacity;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String department;
    private String companySuffix = "techelevator.com";

// Constructor to receive the first and the last name;
   public Email(String firstName, String lastName){
       this.firstName = firstName;
       this.lastName = lastName;
       System.out.println("User Created: "  + firstName +" " + lastName);
       this.department = setDepartment();
       System.out.println("Department: " + department);
       this.password = setPassword(defaultPasswordLength);
       System.out.println("Your password is: " + password);
       //Combine elements to generate email;
       email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department +"."+companySuffix;
       System.out.println("Your email is: " + email);

   }

 // Ask for the department;
   private String setDepartment(){
       System.out.print("Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter department code: ");
       Scanner keyboard = new Scanner(System.in);
       int choseDepartment = keyboard.nextInt();
       if (choseDepartment == 1) { return "sales";}
       else if (choseDepartment == 2){return "development";}
       else if (choseDepartment == 3){return "accounting";}
       else  if (choseDepartment == 0){return "";}

     return null;
   }
// Generate a random password;
    private String setPassword(int length){
       String paswordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%";
       char[] password = new char[length];
       for (int i = 0; i<length;i++){
      int random = (int) (Math.random() * paswordSet.length());
        password[i] = paswordSet.charAt(random);

       }
  return new String(password);
    }




}
