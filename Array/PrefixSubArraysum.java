package Array;

public class PrefixSubArraysum {
    public static void PrefixSum(int arr[]){
        int sum;
        int max = Integer.MIN_VALUE;
        int pre[] = new int[arr.length];

        pre[0] = arr[0];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            
            for (int j = i; j < arr.length; j++) {
                
                sum = (i == 0) ? pre[j] : pre[j] - pre[i - 1];
               // System.out.print(sum+" ");
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
        PrefixSum(arr);

    }
}