package Array;

public class SubArrayByKadaneAlgo {
    public static void kadaneAlgo(int arr[]){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0,s=0; 
        int end = 0; 

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
           
           if (max < sum) {
                max = sum;
                end = i;
                start = s;
            }

            if (sum < 0) {
                sum = 0;
                s = i + 1; // Reset start index
            }
        }

        System.out.println("Maximum contiguous sum: " + max);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
        System.out.print("Subarray with maximum sum: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int arr[]={-2, -3, 4, -1, -2, 1, 5, -3,-14,1};
        kadaneAlgo(arr); 
    }
}