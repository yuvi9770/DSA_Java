package Array_2D;

public class RowSum {
    public static void sum(int num[][], int row){
        int m = num[0].length;
        int sum = 0;
        for (int j = 0; j < m; j++) {
            sum += num[row-1][j];
        }
        System.out.println("Sum is : " + sum);
    }
    public static void main(String[] args) {
        int num[][] = {{1,4,9},
                       {11,4,3},
                       {2,2,3}};

        int row = 2;
        sum(num, row);
    }
}