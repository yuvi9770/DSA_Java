package Array;

public class TrappingRainWater {

    public static void RainWater(int height[]){
        int n = height.length;
        
        int left[] = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }
        
        int right[] = new int[n];
        right[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int WaterLevel = Math.min(left[i], right[i]);

            trappedWater += (WaterLevel - height[i]);
        }
        System.out.println(trappedWater);
    }
    public static void main(String[] args) {
        
        int height[] = {4,2,0,6,3,2,5};
        RainWater(height);
    }
}