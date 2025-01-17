package Recursion;

public class TilingProblem {
    public static int totalWays(int num){
        if (num == 0 || num == 1) {
            return 1;
        }
        // vertical Tiles : totalWays(num - 1)
        // horizontal Tiles : totalWays(num - 2)

        return totalWays(num - 1) + totalWays(num - 2);
    }

    public static void main(String[] args) {
        int num = 5;
        
        System.out.println(totalWays(num));
    }
}