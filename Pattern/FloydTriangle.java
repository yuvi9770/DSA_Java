package Pattern;

import java.util.Scanner;

public class FloydTriangle {

    public static void FloydTriangle_pattern(int row){
        int k=1;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(k + " ");
                k++;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = input.nextInt();

        FloydTriangle_pattern(row);

        input.close();
    }
}
