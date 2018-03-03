package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class SudokuSolver {
    char[][] sudokuTable = new char[9][9];

    public void copyTable(BufferedReader file) throws IOException {
        char ch;
        int column = 0;
        for (int row = 0; row < 9; row++){
            String line = file.readLine();
            for (int j = 0; j < line.length(); j++){
                ch = line.charAt(j);
                if(ch != ','){
                    sudokuTable[row][column] = ch;
                    column++;
                }
            }
            column = 0;
        }
        System.out.println("copied Table: ");
        System.out.println(Arrays.deepToString(sudokuTable));

    }
    public void 
}
