package Array_2D;

public class search_Sortedmatrix {
    public static void stairSearch(int matrix[][], int key){
        int row = 0;
        int col = matrix[0].length-1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Found at: "+ row +"," + col);
                return;
            }
            else if (key < matrix[row][col]) {
                col--;
            }
            else{
                // key > matrix[row][col]
                row++;
            }
        }
        System.out.println("Not Found");
    }
    public static void main(String[] args) {
        int matrix[][] = {{10,20,30,40},
                          {15,25,35,45},
                          {27,29,37,48},
                          {32,33,39,50}};

        int key = 33;
        stairSearch(matrix,key);
    }
}