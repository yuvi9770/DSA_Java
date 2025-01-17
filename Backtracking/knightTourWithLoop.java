package Backtracking;

public class knightTourWithLoop {
    public static void printArr(int chess[][], int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int chess[][], int i, int j, int n){
        if (i < 0 || i >= n || j < 0 || j >= n || chess[i][j] > 0) {
            return false;
        }

        return true;
    }

    public static boolean knight(int chess[][], int i, int j, int n, int move){
        if (move == n*n) {
            return true;
        }

        //moves for a knight
        int[] xMove = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
        
        for (int k = 0; k < 8; k++) {
            int nextI = i + xMove[k];
            int nextJ = j + yMove[k];

            if (isSafe(chess, nextI, nextJ, n)) {
                chess[nextI][nextJ] = move;
                if (knight(chess, nextI, nextJ, n, move + 1)) {
                    return true;
                }
                chess[nextI][nextJ] = 0; // Backtracking
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int n = 5;
        int chess[][] = new int[n][n];

        if (knight(chess, 0, 0, n, 1)) {
            System.out.println("Sol exists:");
            printArr(chess, n);
        } else {
            System.out.println("Sol not exist");
        }
    }
}