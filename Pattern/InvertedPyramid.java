package Pattern;

import java.util.Scanner;

public class InvertedPyramid {

    public static void Inverted_Pyramid(int row){
        for (int i = 1; i <= row ; i++) {

            for (int j = row; j > i; j--) {
                System.out.print("  ");
            }

            for (int k = i ; k > 0 ; k--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = input.nextInt();

        Inverted_Pyramid(row);

        input.close();   
    }
}