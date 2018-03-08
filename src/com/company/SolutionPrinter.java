package com.company;

import java.util.ArrayList;

public class SolutionPrinter {
    ArrayList<Point> points;
    boolean finished;
    public SolutionPrinter(ArrayList<Point> points) {
        this.points = points;
        finished = false;
    }
    public void printSolution(SudokuSolver s, String threadName){
        //print the validated sudoku table
        //terminate all threads
        if(!finished) {
            finished = true;
            System.out.println("Thread that finished is: " + threadName);
            System.out.println("Validated Table: ");
            s.printTable(s.workingTableCopy);
            for(int i = 0; i < points.size(); i++){
                Point p = points.get(i);
                System.out.println("Correct number for row " + p.x + ", column " + p.y + " is: " + s.workingTableCopy[p.x][p.y]);
            }
        }

    }
}
