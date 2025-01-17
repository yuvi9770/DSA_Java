package Pattern;

import java.util.Scanner;

public class Star {

    public static void star_Pattern(int row){
        for (int i = 0; i < row; i++) {

            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
       }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = input.nextInt();
        
        star_Pattern(row);

        input.close();
    }
}