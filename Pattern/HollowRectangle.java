package Pattern;

import java.util.Scanner;

public class HollowRectangle {

    public static void hollow_Rectangle(int row , int column){
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (i==1 || j==1 || i==row || j==column ) {
                    System.out.print("* ");
                }else{
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
        System.out.print("Enter the number of columns: ");
        int column = input.nextInt();
        
        hollow_Rectangle(row, column);
        
        input.close();
    }
}