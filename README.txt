
Files included: Main, MultiThreads, Point, SolutionPrinter, SudokuSolver

There are three methods checking for duplicates in subsquare, row, and column. If there is a duplicate,
0 is assigned to that cell. It saves all the 0 cells into a Point object array, and for each Point object
a guess from 1 through 9 is tried until a valid guess is found by checking for duplicates again in each row, column,
and subsquare. If every guess is utilized and none works, the algorithm goes back one Point object and tries the
previous point again but with a different guess. Main makes 9 helper threads and each thread gets a copy of
the working sudoku table with duplicates, validates the table by trying guesses, and the first thread to finish
prints the validated table.
