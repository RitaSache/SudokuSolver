package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String fileName = "test4.txt";

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            SudokuSolver s = new SudokuSolver();
            s.copyTable(bufferedReader);

            bufferedReader.close();
        } catch (Exception e) {

            System.out.println("Unable to open file '" + fileName + "'");
            e.printStackTrace();
        }
    }
}
