class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numbers.containsKey(target - nums[i])) {
                return new int[] {numbers.get(target - nums[i]), i};
            } else numbers.put(nums[i], i);
        }
        return res;
    }
}