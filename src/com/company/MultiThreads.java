package com.company;


public class MultiThreads extends Thread {
    SudokuSolver d;
    private String threadName;
    SolutionPrinter p;
    MultiThreads(String name, SudokuSolver t, SolutionPrinter m) {
        this.p = m;
        this.d = t;
        threadName = name;
    }

    @Override
    public void run() {
        this.d.validateSudoku();
        this.p.printSolution(d, threadName);
    }
}


