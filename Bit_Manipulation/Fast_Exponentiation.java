package Bit_Manipulation;

public class Fast_Exponentiation {
    public static int fast(int a, int n){
        int ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= a;
            }
            a *= a;
            n >>= 1;

            // if (n%2 == 1) {ans = ans *a; n =n -1;} 
            // else {n = n/2; a = a *a; }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(fast(5, 3));
        System.out.println(fast(2, 8));
    }
}