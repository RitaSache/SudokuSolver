package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class SudokuSolver {
    char[][] sudokuTable = new char[9][9];
    char[][] workingTableCopy = new char[9][9];
    int subSquare = 0;

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
        this.printTable(sudokuTable);

    }

    public void makeWorkingTableCopy(char[][] sudokuTable){
        for (int row = 0; row < 9; row++){
            for (int column = 0; column < 9; column++){
                workingTableCopy[row][column] = sudokuTable[row][column];
            }
        }
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

        int rowStart = 0;
        int rowEnd = 0;
        int columnStart = 0;
        int columnEnd = 0;

        if (subgrid == 1){
            rowStart = 0;
            rowEnd = 3;
            columnStart = 0;
            columnEnd = 3;
        }
        else if (subgrid == 2){
            rowStart = 0;
            rowEnd = 3;
            columnStart = 3;
            columnEnd = 6;
        }
        else if (subgrid == 3){
            rowStart = 0;
            rowEnd = 3;
            columnStart = 6;
            columnEnd = 9;
        }
        else if (subgrid == 4){
            rowStart = 3;
            rowEnd = 6;
            columnStart = 0;
            columnEnd = 3;
        }
        else if (subgrid == 5){
            rowStart = 3;
            rowEnd = 6;
            columnStart = 3;
            columnEnd = 6;
        }
        else if (subgrid == 6){
            rowStart = 3;
            rowEnd = 6;
            columnStart = 6;
            columnEnd = 9;
        }
        else if (subgrid == 7){
            rowStart = 6;
            rowEnd = 9;
            columnStart = 0;
            columnEnd = 3;
        }
        else if (subgrid == 8){
            rowStart = 6;
            rowEnd = 9;
            columnStart = 3;
            columnEnd = 6;
        }
        else if (subgrid == 9){
            rowStart = 6;
            rowEnd = 9;
            columnStart = 6;
            columnEnd = 9;
        }

        char currentValue = workingTableCopy[row][column];
        for(int dupRow = rowStart; dupRow < rowEnd; dupRow++) {
            for (int dupCol = columnStart; dupCol < columnEnd; dupCol++) {
                if (dupRow == row && dupCol == column) {
                    continue;
                }
                if (currentValue == workingTableCopy[dupRow][dupCol]) {
                    workingTableCopy[dupRow][dupCol] = 0;
                }
            }
        }
    }

    public void checkDuplicatesInRows(int row, int column){
        char currentValue = workingTableCopy[row][column];
        for (int dupColumn = 0; dupColumn < 9; dupColumn++){
            if (dupColumn == column) {
                continue;
            }
            if (currentValue == workingTableCopy[row][dupColumn]) {
                workingTableCopy[row][dupColumn] = 0;
            }

        }
    }

    public void printTable(char[][] table) {

        for (int row = 0; row < 9; row++) {
            if (row == 3 || row == 6)
                System.out.println();

            for(int column = 0; column < 9; column++) {
                if(column == 3 || column == 6)
                    System.out.print(" ");

                System.out.print(table[row][column]);
                System.out.print(",");
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();
    }
}
