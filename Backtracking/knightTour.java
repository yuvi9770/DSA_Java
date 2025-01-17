package Backtracking;

public class knightTour {
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

        if (isSafe(chess, i, j, n)) {
            chess[i][j] = move;
            
            if (knight(chess, i-2, j+1, n, move+1)) {
                return true;
            }
            if (knight(chess, i-1, j+2, n, move+1)) {
                return true;
            }
            if (knight(chess, i+1, j+2, n, move+1)) {
                return true;
            }
            if (knight(chess, i+2, j+1, n, move+1)) {
                return true;
            }
            if (knight(chess, i+2, j-1, n, move+1)) {
                return true;
            }
            if (knight(chess, i+1, j-2, n, move+1)) {
                return true;
            }
            if (knight(chess, i-1, j-2, n, move+1)) {
                return true;
            }
            if (knight(chess, i-2, j-1, n, move+1)) {
                return true;
            }
            chess[i][j] = 0;
        }

        return false;
    }
    
    public static void main(String[] args) {
        int n = 5;
        int chess[][] = new int[n][n];

        if (knight(chess, 0, 0, n, 0)) {
            System.out.println("Sol exists:");
            printArr(chess, n);
        } else {
            System.out.println("Sol not exist");
        }
    }
}