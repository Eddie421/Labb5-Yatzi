package com.company;

import java.util.Scanner;

public class Yatzi {
    private Die[] dice;
    private int turn = 0;
    private Scanner sc = new Scanner(System.in);

    void setDice(Die[] dice) {
        this.dice = dice;
    }

    private void createDice() {
        dice = new Die[5];
        for (int i = 0; i < 5; i++) {
            dice[i] = new Die();
        }
    }

    private void rollDice() {
        for (int i = 0; i < dice.length; i++) {
            dice[i].roll();
            System.out.println(i + ": " + "Dice shows " + dice[i].getValue());
        }
    }

    boolean isYatzi() {
        boolean yatzi = true;
        for (int i = 1; i < 5; i++) {
            if (dice[i].getValue() != dice[i - 1].getValue()) {
                yatzi = false;
                break;
            }
        }
        return yatzi;
    }

    private boolean isGameOnGoing() {

        return turn != 3;
    }

    public void startGame() {
        createDice();
        turn = 0;
        while (isGameOnGoing()) {
            if (turn == 0) {
                System.out.println("Welcome to Yatzi!");

            }
            System.out.println("Starting turn " + (turn + 1) + " of 3, rolling dice.");
            rollDice();

            if (isYatzi()) {
                System.out.println("You got YATZI! in " + dice[0].getValue() + "'s");
                return;
            }
            if (turn != 2) {
                System.out.println("Want to throw again? (y for yes, anything else for no)");
                if (sc.next().equals("y")) {
                    ++turn;
                    continue;
                }

            } else {
                System.out.println("Game over! Want to play again?");
                if (sc.next().equals("y")) {
                    turn = 0;
                    continue;
                }
            }
            break;

        }
    }

    public static void main(String[] args) {
        Yatzi yatzi = new Yatzi();
        yatzi.startGame();
    }
}
