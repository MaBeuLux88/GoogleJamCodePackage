package com.google;

import java.util.HashMap;
import java.util.Map;

class PreProcess {

    PreProcess() {
        generate();
    }

    Map<Integer, Integer> getSquares() {
        return squares;
    }

    private Map<Integer, Integer> squares = new HashMap<>();

    private void generate() {
        for (int i = 0; i < 15; i++)
            squares.put(i, i * i);
    }
}
