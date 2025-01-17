package Pattern;

import java.util.Scanner;

public class Butterfly {

    public static void butterfly(int n){
        int m= 2*n;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print("* ");
            }
            for (int j = i+1; j <= m-i; j++) {
                System.out.print("  ");
            }
            for (int j = i; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = n; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("* ");
            }
            for (int j = i+1; j <= m-i; j++) {
                System.out.print("  ");
            }
            for (int j = i; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = input.nextInt();

        butterfly(row);

        input.close();   
    }
}