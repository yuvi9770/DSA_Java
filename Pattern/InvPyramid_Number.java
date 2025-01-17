package Pattern;

import java.util.Scanner;

public class InvPyramid_Number {

    public static void pyramid_number(int row){
        for (int i = row; i > 0; i--) {

            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = input.nextInt();

        pyramid_number(row);

        input.close();     
    }
}