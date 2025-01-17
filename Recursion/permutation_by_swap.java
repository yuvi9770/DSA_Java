package Recursion;

public class permutation_by_swap {
    public static void swap(char[] str, int i,int start){
        char temp = str[i];
        str[i] = str[start];
        str[start] = temp;
    }

    public static void perm(char[] str, int start, int end){
        if (start == end) {
            System.out.println(str);
            return;
        }

        for (int i = start; i <= end; i++) {
            swap(str, i, start);
            perm(str, start+1, end);
            // backtracking
            swap(str, i, start);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        
        perm(str.toCharArray(), 0, str.length()-1);
    }
}