package Array;

public class LargestNum {

    public static int getLargest(int arr[]){
        //This can be initilize with Integer.MIN_VALUE
        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        int arr[] ={10,5,3,14,6,124,3};

        System.out.println("Largest number: "+ getLargest(arr));
        
    }
}
