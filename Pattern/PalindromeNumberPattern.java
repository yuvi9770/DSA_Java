package Pattern;

import java.util.Scanner;

public class PalindromeNumberPattern {
    public static void PalindromePattern(int n){
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n-i; j++) {
                System.out.print("  ");
            }

            for (int j = i; j > 0; j--) {
                System.out.print(j +" ");
            }

            for (int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = input.nextInt();

        PalindromePattern(row);

        input.close(); 
    }
}