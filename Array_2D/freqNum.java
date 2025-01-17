package Array_2D;

public class freqNum {
    public static void newmethod(int arr[][], int num){
        int count = 0;
        for (int[] i : arr) {
            for (int j : i) {
                if (num == j) {
                    count++;
                }
            }
        }
        System.out.printf("frequency of %d is %d ", num, count);
    }

    public static void frequency(int arr[][], int num){
        int count = 0;
        int n = arr.length, m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (num == arr[i][j]) {
                    count++;
                }
            }
        }
        System.out.printf("frequency of %d is %d ", num, count);
    }
    public static void main(String[] args) {
        int arr[][] = {{4,7,8},
                       {8,8,7}};
        
        int num = 7;
        // frequency(arr, num);
        newmethod(arr, num);
    }
}
