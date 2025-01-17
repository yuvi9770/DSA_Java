package Array;

public class MaxSubArraySum {

    public static void MaxSum(int arr[]){
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            
            for (int j = i; j < arr.length; j++) {
                int sum =0;
                for (int k = i; k <=j; k++) {
                    sum += arr[k];
                }
                //System.out.print(sum+" ");
                if (max < sum) {
                    max= sum;
                }
            }
          // System.out.println();
        }

        System.out.println("Max number: "+max);
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10}; 
        MaxSum(arr);
    }
}
