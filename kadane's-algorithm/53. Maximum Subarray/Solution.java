class Solution {
    public int maxSubArray(int[] nums) {
        int curentSum = nums[0];
        int maxSum = nums[0];

        for (int i =1 ; i < nums.length; i++) {
            curentSum = Math.max(nums[i], curentSum + nums[i]);

            maxSum = Math.max(curentSum, maxSum);
        }

        return maxSum;
    }
}