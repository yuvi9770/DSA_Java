package Backtracking;

import java.util.Arrays;

public class knightAttack {
    public static void printArr(char board[][], int n){
        System.out.println("----chess board----");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char board[][], int i, int j, int n){

        if (i-1 >= 0 && j-2 >= 0 && board[i-1][j-2] == 'N') {
            return false;
        }

        if (i-2 >= 0 && j-1 >= 0 && board[i-2][j-1] == 'N') {
            return false;
        }

        if (i-2 >= 0 && j+1 < n && board[i-2][j+1] == 'N') {
            return false;
        }

        if (i-1 >= 0 && j+2 < n && board[i-1][j+2] == 'N') {
            return false;
        }

        return true;
    }

    public static void knight(char board[][], int  i, int j, int n, int count){

        if (i == n) {
            if (count >= n) {
                printArr(board, n);
            }
            return;
        }

        if (j == n) {
            // Move to the next row
            knight(board, i + 1, 0, n, count);
            return;
        }

        if(isSafe(board, i, j, n)){
            board[i][j] = 'N';
            knight(board, i, j + 1, n, count+1); // Continue in same row
            board[i][j] = 'x';
        }

        knight(board, i, j + 1, n, count);
    }

    public static void main(String[] args) {
        int n = 2;

        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], 'x');
        }

        knight(board, 0, 0, n, 0);
    }
}