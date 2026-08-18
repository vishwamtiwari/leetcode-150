import java.util.*;
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;

        int waterTrapped = 0;
        int n = height.length;
        int[] leftMax = leftMax(height, n);
        int[] rightMax = rightMax(height, n);

        for (int i = 1; i < n; i++) {
            int h = Math.min(leftMax[i], rightMax[i]) - height[i];
            waterTrapped += h;
        }
        return waterTrapped;
    }

    public int[] leftMax(int[] height, int n) {
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        return leftMax;
    }
    public int[] rightMax(int[] height, int n) {
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        return rightMax;
    }
}