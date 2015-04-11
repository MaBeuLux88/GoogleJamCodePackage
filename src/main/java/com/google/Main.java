package com.google;

import java.util.Locale;
import java.util.Scanner;

/**
 * Main class. The only thing you have to do here is to create a problem. You
 * have to read the data given for each problem and make sure you set them
 * correctly into the problem.
 */
public class Main extends AbstractCodeJam {

    /**
     * That's how we read problems. This method must be updated for every
     * problems. NOTE: No need to worry about the number of case. It's already
     * done. You just have to worry about the content of ONE problem.
     *
     * @param scan The problem.in ( = the input).
     * @return A ProblemSample: instance of a problem we want to solve.
     */
    protected ProblemSample readProblem(Scanner scan) {
        ProblemSample pb = new ProblemSample();
        scan.useLocale(Locale.US);

        // READ AND SET the variables in the ProblemSample.
        // Available functions to help you:
        // - carriageReturn
        // - readInteger
        // - readBigInteger
        // - readBigDecimal
        // - readLong
        // - readDouble
        // - readString
        // - readListInteger
        // - readListDouble
        // - readMapString
        // - readMapInteger

        pb.setFirst(scan.nextInt());
        carriageReturn(scan);

        int[][] cardsOne = readMapInteger(4, 4, scan);
        pb.setCardsOne(cardsOne);

        pb.setSecond(scan.nextInt());
        carriageReturn(scan);

        int[][] cardsTwo = readMapInteger(4, 4, scan);
        pb.setCardsTwo(cardsTwo);

        return pb;
    }

}
