package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String fileName = "dup1.txt";

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            SudokuSolver s = new SudokuSolver();
            s.copyTable(bufferedReader);

            bufferedReader.close();
            s.makeWorkingTableCopy(s.sudokuTable);

            for (int row = 0; row < 9; row++) {
                for (int column = 0; column < 9; column++) {
                    s.checkDuplicates(row, column);
                    s.checkDuplicatesInRows(row, column);
                    s.checkDuplicatesInColumns(row, column);
                }
            }
            System.out.println("duplicate Table: ");
            s.printTable(s.workingTableCopy);

        } catch (Exception e) {

            System.out.println("Unable to open file '" + fileName + "'");
            e.printStackTrace();
        }
    }
}
