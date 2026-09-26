class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;

        if (len == 1)
            return 0;

        if (len == 2) {
            if (nums[0] > nums[1])
                return 0;
            if (nums[0] < nums[1])
                return 1;
        }

        if (nums[0] > nums[1])
            return 0;
        if (nums[len - 1] > nums[len - 2])
            return len - 1;

        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = left + (right - left)/2;

            if (nums[mid] < nums[mid+1])
                left = mid + 1;
            else if (nums[mid] > nums[mid+1])
                right = mid;
        }

        return left;
    }
}