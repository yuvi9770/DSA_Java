package Pattern;

import java.util.Scanner;

public class Character_pattern {

    public static void Char_Pattern(int row){
        char c ='A';
        for (int i = 1; i <= row; i++) {

            for (int j = 1; j <= i; j++) {      
                System.out.print(c +" ");
                c++;
            }
            System.out.println();
       }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = input.nextInt();

        Char_Pattern(row);

        input.close(); 
    }
}