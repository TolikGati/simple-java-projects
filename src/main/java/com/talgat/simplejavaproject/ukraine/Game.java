package com.talgat.simplejavaproject.ukraine;

import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner keyboard = new Scanner(System.in);
    Random rand = new Random();

  String[] enemies = {"Specnaz", "Morpeh", " Ork", "Pilot"};
  // Enemies vitals;
  int maxEnemyHealth = 80;
  int enemyAttackDamage = 10;
  // Players vitals;
    int health = 110;
    int attackDamage = 25;
    int numHealthPotions = 4;
    int healthPotionHealAmount = 30;
    int healthPotionDropChance = 50;

    boolean running = true;

    public void startTheGame(){
        System.out.println("Welcome to the battlefield Ukraine!");

     ATTEMPT:
        while (running){
            System.out.println("__________________________________________");
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");

            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy+ "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1.Attack");
                System.out.println("\t2.Drink health potion");
                System.out.println("\t3.Run!");

                String input = keyboard.nextLine();
                if (input.equals("1")){
                    int damageTaken = rand.nextInt(enemyAttackDamage);
                    int damageMade = rand.nextInt(attackDamage);
                    enemyHealth -= damageMade;
                    health -= damageTaken;
                    System.out.println("\t>You strike the " + enemy+ " for " + damageMade+ " damage.");
                    System.out.println("\t>You received " + damageTaken + " damaage  in retaliation.");

                    if (health<1){
                        System.out.println("\t> You have taken to mush damage, you are to weak to continue.");
                        break;
                    }


                } else if (input.equals("2")){
                    if (numHealthPotions > 0){
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t>You drink health potion, healing yourself for " + healthPotionHealAmount+ "."
                                          +  "\n\t> You now have " + health + " HP."
                                           + "\n\t>You have " + numHealthPotions + " health potions left.\n");

                    } else {
                        System.out.println("\t>You  have no health potions left! Defeat enemies for a chance to get one!\n");
                    }

                } else if (input.equals("3")){
                    System.out.println("\t>You run away from " + enemy+ "!");
                    continue ATTEMPT;

                } else {
                    System.out.println("\t>Invalid command!");

                }
            }
            if (health < 1){
                System.out.println("\t> You crawl out of the battle!");
                break;
            }
            System.out.println("----------------------------------");
            System.out.println("# " + enemy + " was defeated! # ");
            System.out.println("# You have " + health+ " health left.");
            if (rand.nextInt(100) < healthPotionDropChance){
                numHealthPotions++;
                System.out.println(" # The " + enemy+ " dropped a health potion! # ");
                System.out.println(" # You now have " + numHealthPotions + " health potion(s)! #");

            }
            System.out.println("---------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting.");
            System.out.println("2. Exit battlefield.");

            String input = keyboard.nextLine();
             while (!input.equals("1") && !input.equals("2")){
                 System.out.println("Invalid command!");
                 input = keyboard.nextLine();
             } if (input.equals("1")){
                System.out.println(" You can continue on your mission.");

            } else if (input.equals("2")){
                System.out.println("You exit the battlefield victorious!");
                break;

            }




        }
        System.out.println("Thank you for playing.");


    }



}
