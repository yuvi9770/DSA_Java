package Bit_Manipulation;

public class mod_fast_Exponentiation {
    public static int mod_fast(int a, int n, int mod){
        int ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = (ans *a) % mod;
            }
            a = (a*a) % mod;
            n >>= 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(mod_fast(23, 3, 30));
    }
}