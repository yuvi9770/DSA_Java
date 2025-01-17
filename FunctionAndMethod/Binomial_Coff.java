package FunctionAndMethod;

public class Binomial_Coff {

    public static int factorial(int n){
        int fact =1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int Binomial(int n, int r){
        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_nmr = factorial(n-r);

        int bion = fact_n / (fact_r*fact_nmr);
        return bion;
    }
    
    public static void main(String[] args) {
        System.out.println(Binomial(5, 4));
    }
}
