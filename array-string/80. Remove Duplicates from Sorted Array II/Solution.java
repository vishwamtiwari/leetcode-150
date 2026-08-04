class Solution {
    public int removeDuplicates(int[] nums) {
        int writer = 2;
        int len = nums.length;

        for (int i = 2; i < len; i++) {
            if (nums[i] != nums[writer - 2]) {
                nums[writer] = nums[i];
                writer++;
            }
        }
        return writer;
    }
}