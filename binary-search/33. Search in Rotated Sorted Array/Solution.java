class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target)
            return mid;

        //left half of the array is sorted
        if (nums[left] <= nums[mid])
            if (nums[left] <= target && nums[mid] > target)
                return binarySearch(nums, target, left, mid-1);
            else
                return binarySearch(nums, target, mid + 1, right);

            //right half of the array is sorted
        else {
            if (nums[mid] < target && target <= nums[right])
                return binarySearch(nums, target, mid + 1, right);
            else
                return binarySearch(nums, target, left, mid-1);
        }
    }
}