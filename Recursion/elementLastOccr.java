package Recursion;

public class elementLastOccr {
    // check from last index
    public static int LastOccr(int arr[],int i,int key){
        if (arr[i] == key) {
            return i;
        }
        if (i == 0) {
            return -1;
        }
        return LastOccr(arr, --i, key);
    }

    //check from first index
    public static int checkOcc(int arr[],int i,int key){
        if (i == arr.length) {
            return -1;
        }
        int isFound = checkOcc(arr, i+1, key);

        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }
    
    public static void main(String[] args) {
        int arr[] = {1,4,2,5,23,5,2,4,23,5,23};
        int key = 5;
        int index = LastOccr(arr, arr.length - 1, key);
        // int index = checkOcc(arr, 0, key);
        if (index == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("Found at index : " + index);
        }
    }
}