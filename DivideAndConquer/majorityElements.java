package DivideAndConquer;

public class majorityElements {
    public static int major(int nums[]){
        int count = 0;
        int prev = Integer.MIN_VALUE;
        // Boyer-Moore Voting Algorithm
        for (int i : nums) {
            if (count == 0) {
                prev = i;
                count++;
            }else if(prev == i){
                count++;
            }else {
                // count > 0
                count--;
            }
        }

        return prev;
    }
    public static void main(String[] args) {
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(major(nums));
    }
}