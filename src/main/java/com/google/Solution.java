package com.google;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        scan.useLocale(Locale.US);
        int testCases = scan.nextInt();
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            Problem problem = readProblem(testCase, scan);
            problem.solve();
        }
    }

    private Problem readProblem(int testCase, Scanner scan) {
        return new Problem(testCase, scan.nextInt());
    }

    void carriageReturn(Scanner scan) {
        scan.nextLine();
    }

    /**
     * Read list of doubles on a single line and carriage return at the end.
     *
     * @param numberToRead Number of doubles to read on the line.
     * @param scan         scanner
     * @return List of the doubles.
     */
    List<Double> readListDouble(int numberToRead, Scanner scan) {
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
    List<Integer> readListInteger(int numberToRead, Scanner scan) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numberToRead; i++) {
            list.add(scan.nextInt());
        }
        carriageReturn(scan);
        return list;
    }

    /**
     * Read an array of integers separated by whitespace
     *
     * @param height height
     * @param width  width
     * @param scan   scanner
     * @return Two dimensions array of integers.
     */
    int[][] readMapInteger(int height, int width, Scanner scan) {
        int[][] map = new int[height][width];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = scan.nextInt();
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
    String[][] readMapString(int height, int width, Scanner scan) {
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
     * Read a String made of integers with a carriage return at the end of the line (= no need to
     * make it manually) and transform it into a list of integers.
     *
     * @param scan scanner
     * @return String
     */
    List<Integer> readStringAsListInteger(Scanner scan) {
        String string = scan.nextLine();
        char[] chars = string.toCharArray();
        List<Integer> listIntegers = new ArrayList<>();
        for (char aChar : chars) {
            listIntegers.add(Integer.valueOf(String.valueOf(aChar)));
        }
        return listIntegers;
    }

    static class Problem {
        private final int testCase;
        private final int n;

        Problem(int testCase, int n) {
            this.testCase = testCase;
            this.n = n;
        }

        Object getSolution() {
            return n;
        }

        void solve() {
            System.out.println("Case #" + testCase + ": " + getSolution());
        }

        /**
         * Display the content of a list.
         *
         * @param list List of whatever as far as you can run toString() on it.
         */
        void printList(List<?> list) {
            for (Object aList : list)
                System.err.print(aList.toString() + " ");
            System.err.println();
        }

        /**
         * Display a map of strings.
         *
         * @param map map of strings to print
         */
        void printMap(String[][] map) {
            for (String[] element : map) {
                for (String element2 : element)
                    System.err.print(element2);
                System.err.println();
            }
        }

        /**
         * Display a map of integers.
         *
         * @param map map of integers to print
         */
        void printMap(int[][] map) {
            for (int[] aMap : map) {
                for (int i : aMap)
                    System.err.print(i + " ");
                System.err.println();
            }
        }
    }
}
