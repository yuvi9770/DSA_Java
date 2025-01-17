package Backtracking;

public class sudokuSolver {
    public static void printSudo(int sudoku[][]){
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static boolean isSafe(int sudoku[][], int row, int col, int digit){
        // column (vertical direction)
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // row (horizontal direction)
        for (int i = 0; i <= 8; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }

        // grid
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }


        return true;
    }


    public static boolean solver(int sudoku[][], int row, int col){
        if (row == 8 && col == 9) {
            return true;
        }
 
        //recursion
        if (col == 9) {
            row++;
            col = 0;
        }

        if (sudoku[row][col] != 0) {
            return solver(sudoku, row, col+1);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (solver(sudoku, row, col+1)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int sudoku[][] = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        
        if (solver(sudoku, 0, 0)) {
            System.out.println("sol possible");
            printSudo(sudoku);
        } else {
            System.out.println("No sol possible");
        }
    }
}