package com.google;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * This class contains the Thread Management and some helpful functions to ease
 * the problem reading issue.
 */
public abstract class AbstractCodeJam {

    /**
     * Verbosity. True = ON / False = OFF.
     */
    private final static boolean debug = true;

    /**
     * The pool size of the ExecutorService. I think that this number should be
     * equal to the numbers of available processors. Feel free to update if your
     * religion says something different.
     */
    private final static int nbThreads = Runtime.getRuntime().availableProcessors();

    /**
     * Log method. Update the "debug" attribute to be verbose or not.
     *
     * @param string  The String you want to print in the console.
     * @param newLine True if you want a carriage return else false.
     */
    protected static void log(String string, boolean newLine) {
        if (debug) {
            if (newLine) {
                System.out.println(string);
            } else {
                System.out.print(string);
            }
        }
    }

    /**
     * Main function.
     *
     * @param args no args needed
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        try {
            new Main().solveProblems(new PrintStream(new File("result.out")));
        } catch (Exception e) {
            System.err.println("Shit happens...");
            e.printStackTrace();
        }
    }

    /**
     * Carriage return.
     *
     * @param scan scanner
     */
    protected void carriageReturn(Scanner scan) {
        scan.nextLine();
    }

    /**
     * Read a big decimal without carriage return.
     *
     * @param scan scanner
     * @return BigDecimal
     */
    protected BigDecimal readBigD(Scanner scan) {
        return scan.nextBigDecimal();
    }

    /**
     * Read a big integer without carriage return.
     *
     * @param scan scanner
     * @return BigInteger
     */
    protected BigInteger readBigInteger(Scanner scan) {
        return scan.nextBigInteger();
    }

    /**
     * Read a double without carriage return.
     *
     * @param scan scanner
     * @return double
     */
    protected double readDouble(Scanner scan) {
        return scan.nextDouble();
    }

    /**
     * Read an integer without carriage return.
     *
     * @param scan scanner
     * @return integer
     */
    protected int readInteger(Scanner scan) {
        return scan.nextInt();
    }

    /**
     * Read list of doubles on a single line and carriage return at the end.
     *
     * @param numberToRead Number of doubles to read on the line.
     * @param scan         scanner
     * @return List of the doubles.
     */
    protected List<Double> readListDouble(int numberToRead, Scanner scan) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < numberToRead; i++) {
            list.add(scan.nextDouble());
        }
        carriageReturn(scan);
        return list;
    }

    /**
     * Read list of integers on a single line and carriage return at the end.
     *
     * @param numberToRead Number of integers to read on the line.
     * @param scan         scanner
     * @return List of the integers.
     */
    protected List<Integer> readListInteger(int numberToRead, Scanner scan) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numberToRead; i++) {
            list.add(scan.nextInt());
        }
        carriageReturn(scan);
        return list;
    }

    /**
     * Read a long without carriage return.
     *
     * @param scan scanner
     * @return long
     */
    protected long readLong(Scanner scan) {
        return scan.nextLong();
    }

    /**
     * Read an array of integers separated by whitespace
     *
     * @param height height
     * @param width  width
     * @param scan   scanner
     * @return Two dimensions array of integers.
     */
    protected int[][] readMapInteger(int height, int width, Scanner scan) {
        int[][] map = new int[height][width];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = readInteger(scan);
            }
            carriageReturn(scan);
        }
        return map;
    }

    /**
     * Read an array of Characters and generate an array of strings (easier to
     * manipulate).
     *
     * @param height height
     * @param width  width
     * @param scan   scanner
     * @return Two dimensions array of Strings. Each string will contain a
     * single character.
     */
    protected String[][] readMapString(int height, int width, Scanner scan) {
        String[][] map = new String[height][width];
        for (int i = 0; i < map.length; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = line.substring(j, j + 1);
            }
        }
        return map;
    }

    /**
     * That's how we read problems. This method must be updated for every
     * problems.
     *
     * @param scan The problem.in ( = the input).
     * @return A ProblemSample: the instance of a problem we have to solve.
     */
    protected abstract ProblemSample readProblem(Scanner scan);

    /**
     * Read a String with a carriage return at the end of the line (= no need to
     * make it manually).
     *
     * @param scan scanner
     * @return String
     */
    protected String readString(Scanner scan) {
        return scan.nextLine();
    }

    /**
     * Read a String made of integers with a carriage return at the end of the line (= no need to
     * make it manually) and transform it into a list of integers.
     *
     * @param scan scanner
     * @return String
     */
    protected List<Integer> readStringAsListInteger(Scanner scan) {
        String string = scan.nextLine();
        char[] chars = string.toCharArray();
        List<Integer> listIntegers = new ArrayList<>();
        for (char aChar : chars) {
            listIntegers.add(new Integer(String.valueOf(aChar)));
        }
        return listIntegers;
    }

    /**
     * Skip one whitespace character.
     *
     * @param scan scanner
     */
    protected void skipWhiteSpace(Scanner scan) {
        scan.skip(" ");
    }

    /**
     * Multithreaded method responsible of solving all the problems.
     *
     * @param out The result.out file.
     * @throws Exception
     */
    protected void solveProblems(PrintStream out) throws Exception {
        Scanner scan = new Scanner(new File("problem.in"));

        // Read the number of test cases.
        int nbProblems = readInteger(scan);
        carriageReturn(scan);

        // List of all the problems we have to solve.
        List<ProblemSample> listProblems = new ArrayList<>();

        Main.log("Read the problems...", true);

        // Read the input file and instantiate the problems; populate the list
        // of problems.
        for (int i = 1; i <= nbProblems; i++) {
            ProblemSample problem = readProblem(scan);
            problem.print(i);
            listProblems.add(problem);
        }

        Main.log("Processing... Waiting for all the threads to be done...", true);

        // Run the problems in parallel
        ExecutorService executor = Executors.newFixedThreadPool(nbThreads);
        List<Future<Object>> futures = executor.invokeAll(listProblems);
        executor.shutdown();

        // Generate the output once all the problems are solved.
        int i = 0;
        for (Future<Object> future : futures) {
            i++;
            Main.log("Solution " + i + ": " + future.get().toString(), true);
            out.println("Case #" + i + ": " + future.get().toString());
        }
    }

}
