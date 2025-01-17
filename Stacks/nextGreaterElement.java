package Stacks;

import java.util.Stack;

public class nextGreaterElement {
    public static void greater(int arr[],Stack<Integer> s,int nxtGrt[]){
        // next greater element at right
        for (int i = arr.length-1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nxtGrt[i] = -1;
            } else {
                nxtGrt[i] = arr[s.peek()];
            }

            s.push(i);
        }

        for (int i = 0; i < nxtGrt.length; i++) {
            System.out.print(nxtGrt[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        Stack<Integer> s = new Stack<>();
        int nxtGrt[] = new int[arr.length];

        greater(arr, s, nxtGrt);
    }
}