package com.company;

import java.util.ArrayList;


public class Point {

    public int x;
    public int y;

    public ArrayList<Character> randomNumbers;

    public Point(int row, int column) {
        this.x = row;
        this.y = column;
        randomNumbers = new ArrayList<>(9);
    }
}
