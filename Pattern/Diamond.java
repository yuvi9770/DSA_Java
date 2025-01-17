package Pattern;

import java.util.Scanner;

public class Diamond {

    public static void Diamond_pattern(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n-i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= (2 * i)-1; j++) {
                System.out.print("* ");
            }
            // for (int j = 2; j <= i; j++) {
            //     System.out.print("* ");
            // }
            System.out.println();
        }

        for (int i = n; i > 0; i--) {
            for (int j = 1; j <=n-i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= (2 * i)-1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = input.nextInt();

        Diamond_pattern(row);

        input.close(); 
    }
}