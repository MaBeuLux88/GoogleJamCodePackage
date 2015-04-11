package com.google;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * The problem we have to solve. First create the attributes you need to solve
 * this problem then update the readProblem method in the Main class. Then
 * implement the solve function.
 */
public class ProblemSample extends Problem implements Callable<Object> {

    int first, second;

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int[][] getCardsOne() {
        return cardsOne;
    }

    public void setCardsOne(int[][] cardsOne) {
        this.cardsOne = cardsOne;
    }

    public int[][] getCardsTwo() {
        return cardsTwo;
    }

    public void setCardsTwo(int[][] cardsTwo) {
        this.cardsTwo = cardsTwo;
    }

    int[][] cardsOne, cardsTwo;

    /**
     * Solve the problem and SET THE SOLUTION at the end.
     */
    @Override
    protected void solve() {

        int counter = 0;
        int value = -1;

        List<Integer> rowOne = new ArrayList<>();
        List<Integer> rowTwo = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            rowOne.add(cardsOne[first - 1][i]);
            rowTwo.add(cardsTwo[second - 1][i]);
        }

        Main.log("Liste UNE", true);
        printList(rowOne);
        Main.log("Liste DEUX", true);
        printList(rowTwo);

        for (int j = 0; j < 4; j++) {
            int test = rowOne.get(j);
            if (rowTwo.contains(test)) {
                counter++;
                value = test;
            }
        }

        // Do not forget to set the solution!

        if (counter == 1) {
            this.setSolution(value);
        } else if (counter == 0) {
            this.setSolution("Volunteer cheated!");
        } else {
            this.setSolution("Bad magician!");
        }

    }

    @Override
    protected void print(int number) {
        Main.log("Problem " + number + ": " + first + " " + second, true);
        Main.log("ONE", true);
        printMap(cardsOne);
        Main.log("TWO", true);
        printMap(cardsTwo);
    }

}
