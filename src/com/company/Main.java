package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Point> duplicates = new ArrayList<>();

        ArrayList<MultiThreads> threads = new ArrayList<>();
        SolutionPrinter o = new SolutionPrinter(duplicates);
        String fileName = "test4.txt";

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            SudokuSolver s = new SudokuSolver();
            s.copyTable(bufferedReader);

            bufferedReader.close();
            s.makeWorkingTableCopy(s.sudokuTable);
            for (int row = 0; row < 9; row++) {
                for (int column = 0; column < 9; column++) {
                   boolean dupsInSubsquare = s.hasDuplicatesInSubSquare(row, column);
                   boolean dupsInRow = s.hasDuplicatesInRows(row, column);
                   boolean dupsInColumns = s.hasDuplicatesInColumns(row, column);

                   if(dupsInSubsquare || dupsInRow || dupsInColumns) {
                       Point d = new Point(row, column);
                       duplicates.add(d);
                       System.out.println("Error in row: " + d.x + ", column: " + d.y);
                   }
                }
            }
            System.out.println();
            System.out.println();
            for(int i = 0; i < duplicates.size(); i++){
                Point p = duplicates.get(i);
                s.workingTableCopy[p.x][p.y] = 0;
            }
            System.out.println("duplicate Table:");
            s.printTable(s.workingTableCopy);

            for(int i = 0; i < 9; i++) {
                SudokuSolver h = new SudokuSolver();
                h.workingTableCopy = s.copyWorkingTable(s.workingTableCopy); //create a new sudoku solver and make a copy of original working table, then put it into new sudokusolver
                MultiThreads t = new MultiThreads("thread" + i, h, o);
                t.start();
                threads.add(t);
            }
            for(int i = 0; i < 9; i++){
                threads.get(i).join();
            }
        } catch (Exception e) {

            System.out.println("Unable to open file '" + fileName + "'");
            e.printStackTrace();
        }
    }
}
