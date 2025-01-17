package Stacks;

import java.util.Stack;

public class maxAreaHistogram {
    // optimize approach
    public static void maxArea2(int arr[]){
        int maxArea = 0;
        int n = arr.length;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int val = (i == n) ? 0 : arr[i];
            while (!s.isEmpty() && (arr[s.peek()] > val)) {
                int height = arr[s.pop()];
                int width = (s.isEmpty()) ? i : (i-s.peek()-1);   
                maxArea = Math.max(maxArea, width*height);
            }
            s.push(i);
        }

        System.out.println(maxArea);
    }


    // this approach takes 2 stacks
    public static void maxArea(int arr[]){
        int maxArea = 0;
        int n = arr.length;
        int nsr[] = new int[n];
        int nsl[] = new int[n];

        // next smaller right
        Stack<Integer> s = new Stack<>();

        for (int i = n-1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) { 
                nsr[i] = n; // nothing smaller at right so insert arr.length

            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // next smaller left
        s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            nsl[i] = s.isEmpty() ? -1 : s.peek();
            // if (s.isEmpty()) {
            //     nsl[i] = -1; // nothing smaller at left so insert -1 

            // } else {
            //     nsl[i] = s.peek();
            // }
            s.push(i);
        }

        // compute result
        for (int i = 0; i < n; i++) {
            int height = arr[i]; 
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }

        System.out.println(maxArea);

    }
    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        maxArea(arr);
        maxArea2(arr);
    }
}