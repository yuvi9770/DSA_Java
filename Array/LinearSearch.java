package Array;

public class LinearSearch {

    public static int linear_Search(int arr[], int key){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        
       int arr[] ={3,45,6,87,76,34,2,7,43};
       int key = 7;
       int Linear = linear_Search(arr, key);

       if (Linear == -1) {
        System.out.println("Element not found");
       } else {
        System.out.println("Element found at index: " + Linear);
       }

    }
}