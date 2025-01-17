package Pattern;

import java.util.Scanner;

public class InvertedStar {

    public static void Inverted_Star(int row){
        for (int i = row; i > 0; i--) {
        
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

        Inverted_Star(row);

        input.close();  
    }
}