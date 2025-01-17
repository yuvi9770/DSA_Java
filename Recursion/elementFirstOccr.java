package Recursion;

public class elementFirstOccr {
    public static int occr(int arr[],int i,int key){
        if (arr[i] == key) {
            return i;
        }
        if (i == arr.length-1) {
            return -1;
        }
        return occr(arr, ++i, key);
    }
    public static void main(String[] args) {
        int arr[] = {1,4,2,5,23,5,2,4};
        int key = 5;
        int index = occr(arr, 0, key);
        if (index == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("Found at index : " + index);
        }
    }
}