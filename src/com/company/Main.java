package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String fileName = "test4.txt";

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            SudokuSolver s = new SudokuSolver();
            s.copyTable(bufferedReader);

            bufferedReader.close();
            s.makeWorkingTableCopy(s.sudokuTable);
            ArrayList<Point> duplicates = new ArrayList<>();
            for (int row = 0; row < 9; row++) {
                for (int column = 0; column < 9; column++) {
                   boolean dupsinSubsquare = s.hasDuplicatesInSubSquare(row, column);
                   boolean dupsInRow = s.hasDuplicatesInRows(row, column);
                   boolean dupsInColumns = s.hasDuplicatesInColumns(row, column);

                   if(dupsinSubsquare || dupsInRow || dupsInColumns) {
                       Point d = new Point(row, column);
                       duplicates.add(d);
                   }
                }
            }
            for(int i = 0; i < duplicates.size(); i++){
                Point p = duplicates.get(i);
                s.workingTableCopy[p.x][p.y] = 0;
            }
            System.out.println("duplicate Table:");
            s.printTable(s.workingTableCopy);

            s.validateSudoku();
            System.out.println("Validated Table: ");
            s.printTable(s.workingTableCopy);

        } catch (Exception e) {

            System.out.println("Unable to open file '" + fileName + "'");
            e.printStackTrace();
        }
    }
}
