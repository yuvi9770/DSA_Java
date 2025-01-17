package Stacks;

import java.util.Stack;

public class TrappingWater {
    public static int trapped(int height[]){
        Stack<Integer> s = new Stack<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            while (!s.isEmpty() && height[i] > height[s.peek()]) {
                int top = s.pop();
                if (s.isEmpty()) break;

                int width = i - s.peek() - 1;
                int ht = Math.min(height[i], height[s.peek()]) - height[top];
                water += width * ht; 
            }
            s.push(i);
        }

        return water;
    }
    public static void main(String[] args) {
        int heights[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapped(heights));
    }
}