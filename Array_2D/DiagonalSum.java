package Array_2D;

public class DiagonalSum {
    public static void sumDiagonal(int matrix[][]){
        int n = matrix.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            //Primary Diagonal
            sum += matrix[i][i];
            //Secondary Diagonal
            int col = n-1-i;
            if (i != col) {
                sum += matrix[i][col];
            }
        }
        System.out.println(sum);
    }

    public static void sum(int matrix[][]){
        //brute force
        int n = matrix.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
                else if(i+j == n-1){
                    if (i != j) {
                        sum += matrix[i][j];
                    }
                }
            }
        } 
        System.out.println(sum);
    }
    public static void main(String[] args) {
        int matrix[][]={{1,2,3},
                        {4,5,6},
                        {7,8,9},
        };

        sumDiagonal(matrix);
        // sum(matrix);
    }
}