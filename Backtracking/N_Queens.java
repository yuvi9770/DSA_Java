package Backtracking;

public class N_Queens {
    public static void printBoard(char board[][]){
        System.out.println("-------chess board-------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static boolean isSafe(char board[][], int row, int col){
        // vertical up
        for (int i = row-1; i >= 0; i--) {
           if (board[i][col] == 'Q') {
                return false;
            }
        }

        // left diagonal
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--,j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // right diagonal
        for (int i = row-1, j = col+1; i >= 0 && j < board.length ; i--,j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
    
        return true;
    }


    public static void Queens(char board[][], int row){
        if (row == board.length) {
            printBoard(board);
            count++;
            return;
        }

        // column loop
        for (int j = 0; j < board.length; j++) {
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                Queens(board, row+1);
                board[row][j] = 'x'; // backtracking
            }   
        }
    }

    static int count = 0;
    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        Queens(board, 0);
        System.out.println("Total no. of ways to solve n queens = " + count);
    }
}