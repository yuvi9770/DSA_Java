package Pattern;

import java.util.Scanner;

public class square {

    public static void square_Pattern(int side){
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the side of square: ");
        int side = input.nextInt();

        square_Pattern(side);

        input.close();
    }
}