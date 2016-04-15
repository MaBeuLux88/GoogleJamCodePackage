package com.google;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Abstract class Problem. Contains all the common stuff to each Google Jam Code
 * problem and some functions to help the debugging process.
 */
abstract class Problem implements Callable<Object> {

    /**
     * The final solution of the problem you MUST set at the end of the solve
     * method. For a clean output, the toString method must return a decent
     * output.
     */
    private Object solution;

    /**
     * The method we have to implement to solve the problem. DO NOT FORGET TO
     * SET THE SOLUTION AT THE END!!!
     */
    protected abstract void solve();

    /**
     * Print a problem. You can implement this function to make sure you read it
     * correctly in the first place to avoid dummy mistake...
     *
     * @param number the number of the problem
     */
    protected abstract void print(int number);

    /**
     * Getter Solution
     *
     * @return Solution
     */
    private Object getSolution() {
        return solution;
    }

    /**
     * Setter Solution - MUST be used at the end of the solve method.
     *
     * @param solution the final solution of the problem
     */
    void setSolution(Object solution) {
        this.solution = solution;
    }

    /**
     * Method overwritten from Callable<E>. It's called by the Multithreading
     * Management to solve the problems.
     */
    @Override
    public Object call() throws Exception {
        this.solve();
        return getSolution();
    }

    /**
     * Display the content of a list.
     *
     * @param list List of whatever as far as you can run toString() on it.
     */
    protected void printList(List<?> list) {
        for (Object aList : list)
            Main.log(aList.toString() + " ", false);
        Main.log("", true);
    }

    /**
     * Display a map of strings.
     *
     * @param map map of strings to print
     */
    protected void printMap(String[][] map) {
        for (String[] element : map) {
            for (String element2 : element)
                Main.log(element2, false);
            Main.log("", true);
        }
    }

    /**
     * Display a map of integers.
     *
     * @param map map of integers to print
     */
    protected void printMap(int[][] map) {
        for (int[] aMap : map) {
            for (int i : aMap)
                Main.log(String.valueOf(i) + " ", false);
            Main.log("", true);
        }
    }

}
