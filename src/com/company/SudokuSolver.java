package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class SudokuSolver {
    char[][] sudokuTable = new char[9][9];
    char[][] workingTableCopy = new char[9][9];
    int subSquare = 0;
    char[][] duplicateArray = new char[9][9];

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
    public void makeWorkingTableCopy(char[][] sudokuTable){
        for (int row = 0; row < 9; row++){
            for (int column = 0; column < 9; column++){
                workingTableCopy[row][column] = sudokuTable[row][column];
            }
        }

        System.out.println(" Working Table: ");
        System.out.println(Arrays.deepToString(workingTableCopy));
    }
    public int getSubsquare(int row, int column){

        if (row <= 2 && column <= 2) {
            subSquare = 1;
        }
        else if (row <= 2 && column > 2 && column <=5){
            subSquare = 2;
        }
        else if (row <= 2 && column > 5 && column <= 8) {
            subSquare = 3;
        }
        else if (row > 2 && row <= 5 && column <= 2) {
            subSquare = 4;
        }
        else if (row > 2 && row <= 5 && column > 2 && column <=5) {
            subSquare = 5;
        }
        else if (row > 2 && row <= 5 && column > 5 && column <=8) {
            subSquare = 6;
        }
        else if (row > 5 && row <= 8 && column <= 2) {
            subSquare = 7;
        }
        else if (row > 5 && row <= 8 && column > 2 && column <= 5){
            subSquare = 8;
        }
        else if (row > 5 && row <= 8 && column > 5 && column <=8) {
            subSquare = 9;
        }
        return subSquare;
    }

    public void checkDuplicates(int row, int column){
        int subgrid = getSubsquare(row,column);

        if (subgrid == 1){
            char currentValue = sudokuTable[row][column];
            for(int r1 = 0; r1 < 3; r1++){
                for(int c1 = 0; c1 < 3; c1++){
                    if(r1 == row && c1 == column) {
                        continue;
                    }
                    if(currentValue == sudokuTable[r1][c1]) {
                        workingTableCopy[r1][c1] = 0;
                    }
                }
            }
        }
        else if (subgrid == 2){
            char currentValue = sudokuTable[row][column];
            for(int r2 = 0; r2 < 3; r2++){
                for(int c2 = 3; c2 < 6; c2++){
                    if(r2 == row && c2 == column){
                        continue;
                    }
                    if(currentValue == sudokuTable[r2][c2]){
                        workingTableCopy[r2][c2] = 0;
                    }
                }
            }
        }


    }
}
