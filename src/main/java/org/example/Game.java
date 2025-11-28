package org.example;

import java.util.Random;
import java.util.Scanner;

public class Game {
    static void game() {
        startGame();
    }

    static void startGame(){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Welcome to the game 'Guess the number'");
        System.out.println("=======================================");
        System.out.println("Instructions: Choose level, Guess the number :) ");

        boolean play = true;

        while (play) {
            int maxNum = 100;
            boolean validChoice = false;

            while (!validChoice) {
                System.out.println("Choose the level: ");
                System.out.println("1. Easy level(1-50) ");
                System.out.println("2. Middle level(1-100)");
                System.out.println("3. Hard level(1-500)");
                System.out.println("Your choice: ");
                int choice = readInt(sc);

                if (choice == 1) {
                    maxNum = 50;
                    System.out.println("✅Easy level have chosen(1-50)");
                    validChoice = true;
                } else if (choice == 2) {
                    System.out.println("✅Middle level have chosen(1-100)");
                    validChoice = true;
                } else if (choice == 3) {
                    maxNum = 500;
                    System.out.println("🔥Hard level have chosen(1-500)");
                    validChoice = true;
                } else {
                    System.out.println("❌ Wrong choice! Please choose 1, 2 or 3.");
                }
            }

            int secretNum = r.nextInt(maxNum) + 1;


            playRound(sc, secretNum, maxNum);

            System.out.print("Do you want to play again? (yes/no): ");
            String answer = sc.next();

            if (answer.equals("y") || answer.equals("yes") || answer.equals("Y") || answer.equals("Yes")) {
                System.out.println("Ok, let's start new game!");
            } else {
                play = false;
                System.out.println("Thank you for the game! Bye bye!");
            }
        }
    }

    static int readInt(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.print("No. Write number: ");
                sc.next();
            }
        }
    }


    static void playRound(Scanner sc, int secretNum, int maxNum) {
        int attempts = 0;
        boolean guessed = false;

        System.out.println("I chose the number from 1 to " + maxNum + ". Try to Guess!");

        while (!guessed) {
            System.out.print("Your guess: ");
            int guess = readInt(sc);
            attempts++;

            if (guess < 1 || guess > maxNum) {
                System.out.println("The number should be from 1 to " + maxNum + "!");
                continue;
            }

            if (guess == secretNum) {
                System.out.println("🎉 Congratulations! You guess the number " + secretNum);
                System.out.println("Number of attempts: " + attempts);
                guessed = true;
            } else if (guess < secretNum) {
                System.out.println("⬆️ Too little number");
            } else {
                System.out.println("⬇️ Too much");
            }
        }
    }
}