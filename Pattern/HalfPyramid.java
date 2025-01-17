package Pattern;

import java.util.Scanner;

public class HalfPyramid {

    public static void half_Pyramid(int row){
        for (int i = 1; i <= row; i++) {
        
            for (int j = 1; j <= i; j++) {
                System.out.print(j +" ");
            }
            System.out.println();
       }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = input.nextInt();

        half_Pyramid(row);

        input.close();    
    }
}