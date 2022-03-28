package com.talgat.simplejavaproject;

import java.util.Scanner;

public class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

  public   BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance = balance + amount;
            previousTransaction = amount;

        }
    }

    public void withdraw(int amount) {
        if (amount > 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction proceeded");
        }

    }

    public void displayMenu() {
        char option = '\0';
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome: " + customerName);
        System.out.println("Your Id is; " + customerId);
        System.out.println("\n");
        System.out.println("A. Check balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");

        do {

            System.out.println("=============================================");
            System.out.println("Enter an option");
            System.out.println("==============================================");
            option = keyboard.next().toUpperCase().charAt(0);
            System.out.println("\0");

            switch (option) {

                case 'A':
                    System.out.println("__________________________________________");
                    System.out.println("Balance: " + balance);
                    System.out.println("__________________________________________ ");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("___________________________________________");
                    System.out.println("Enter an amount to deposit");
                    System.out.println("____________________________________________");
                    int amount = keyboard.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("_____________________________________________");
                    System.out.println("Enter amount to withdraw");
                    System.out.println("_____________________________________________");
                    int amount2 = keyboard.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("______________________________________________");
                    getPreviousTransaction();
                    System.out.println("_______________________________________________");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("==================================================");
                    break;
                default:
                    System.out.println("Invalid Option! Please enter again.");
                    break;

            }
        } while (option != 'E');
        System.out.println("Thank You for using our services !");
    }

}
