package Array.Questions;

public class rainWater {
    // usint two pointer
    public static void waterCapacity(int height[]){
        int n =height.length;
        int leftMax = height[0];
        int rightMax = height[n-1];
        int water = 0;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (height[i] <= height[j]) {
                leftMax = Math.max(leftMax, height[i]);
                water += leftMax - height[i];
                i++;
            } else {
                rightMax = Math.max(rightMax, height[j]);
                water += rightMax - height[j];
                j--;
            }
        }
        System.out.println("Maximum: " + water);
    }

    // using loop
    public static void Bruteforce(int height[]){
        int n = height.length;

        int left[] = new int[n];
        int right[] = new int[n];
        int trappedWater = 0;
        
        for (int i = 0; i < n; i++) {
            if (i==0) {
                left[0] = height[0];
                right[n-1] = height[n-1];
            } else {
                left[i] = Math.max(left[i-1], height[i]);
                right[n-i-1] = Math.max(height[n-i-1], right[n-i]);
            }
        }

        for (int i = 0; i < n; i++) {
            trappedWater += (Math.min(left[i], right[i]) - height[i]);
        }
        System.out.println("Maximum stores: " + trappedWater);
    }
    public static void main(String[] args) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        // Bruteforce(height);

        waterCapacity(height);
    } 
}