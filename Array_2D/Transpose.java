package Array_2D;

public class Transpose {
    public static void printMatrix(int matrix[][]){

        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void trans(int matrix[][]){
        int row = matrix.length;
        int col = matrix[0].length;
        int trans[][] = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                trans[j][i] = matrix[i][j];
            }
        }
        printMatrix(trans);
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},
                          {4,5,6}};

        System.out.println("Original matrix:");
        printMatrix(matrix);

        System.out.println("Transpose matrix:");
        trans(matrix);
    }
}