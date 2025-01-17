package Pattern;

import java.util.Scanner;

public class Acce {

    public static void pattern(int row, int StartElement){
        for (int i = row; i > 0; i--) {

            for (int j = StartElement ; j >0; j--) {

                String s = String.valueOf(j);
                System.out.print(s.repeat(i));
                // for (int k = i; k >0; k--) {
                //     String s1 = String.valueOf(j);
                //     System.out.print(s1);
                // }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = input.nextInt();
        System.out.print("Enter the StartElement: ");
        int StartElement = input.nextInt();
        
        pattern(row, StartElement);
        
        input.close();
    } 
}