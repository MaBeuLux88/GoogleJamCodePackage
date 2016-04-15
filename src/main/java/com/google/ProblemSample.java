package com.google;

import java.util.concurrent.Callable;

/**
 * The problem we have to solve. First create the attributes you need to solve
 * this problem then update the readProblem method in the Main class. Then
 * implement the solve function.
 */
class ProblemSample extends Problem implements Callable<Object> {

    private int n;

    void setN(int n) {
        this.n = n;
    }

    /**
     * Solve the problem and SET THE SOLUTION at the end.
     */
    @Override
    protected void solve() {
        this.setSolution(n * n);
    }

    @Override
    public String toString() {
        return "ProblemSample{n=" + n + '}';
    }

    @Override
    protected void print(int number) {
        Main.log("Problem " + number + ": " + toString(), true);
    }

}
