class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = nums[0];
        int curentMinSum = nums[0];
        int curentMaxSum = nums[0];
        int minSum = nums[0];
        int maxSum = nums[0];

        for (int i =1 ; i < nums.length; i++) {
            totalSum += nums[i];

            curentMinSum = Math.min(nums[i], curentMinSum + nums[i]);
            curentMaxSum = Math.max(nums[i], curentMaxSum + nums[i]);

            minSum = Math.min(curentMinSum, minSum);
            maxSum = Math.max(curentMaxSum, maxSum);
        }

        return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum;
    }
}