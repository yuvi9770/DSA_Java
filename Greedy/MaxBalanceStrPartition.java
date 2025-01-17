package Greedy;

public class MaxBalanceStrPartition {
    public static int partition(String str){
        if (str.length() == 0) return 0;
        
        int count = 0;
        int result = 0;

        for (char ch : str.toCharArray()) {
            if (ch == 'L') count++;

            else if (ch == 'R') count--;

            if (count == 0) result++;
        }
        return result;
    }
    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";
        System.out.println(partition(str));
    }
}
