package Pattern;

import java.util.Scanner;

public class HollowRhombus {
    public static void hollow_Rhombs(int n){
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n-i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= n; j++) {
                if (i==1 || j==1 || i==n || j==n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = input.nextInt();

        hollow_Rhombs(row);

        input.close();   
    }
}