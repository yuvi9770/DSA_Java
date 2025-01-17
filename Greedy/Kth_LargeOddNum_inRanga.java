package Greedy;

public class Kth_LargeOddNum_inRanga {
    public static int KthOdd(int range[], int k){
        if (k <= 0) return 0;

        int L = range[0];
        int R = range[1];

        if ((R & 1) > 0) { // check if R is odd
            int count = (int)Math.ceil((R-L+1)/2.0); // no. of odd

            if (k > count) return 0;

            return (R - 2*(k-1));

        }else{
            int count = (R-L+1)/2; // no. of odd

            if (k > count) return 0;

            return ((R - 1) - 2*(k-1));

        }
    }
    public static void main(String[] args) {
        int range[] = {-10,10};
        int k = 8;
        System.out.println(KthOdd(range, k));

        System.out.println(KthOdd(new int[] {-3,3}, 1));
    }
}