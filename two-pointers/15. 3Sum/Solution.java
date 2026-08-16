class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            int target = -nums[i];

            if (i != 0 && nums[i] == nums[i-1]) continue;
            twoSum(nums, target, result, i+1);
        }
        return result;
    }

    public static void twoSum(int[] numbers, int target, List<List<Integer>> result, int k) {
        int i = k, j = numbers.length - 1;

        while (i < j) {
            if (numbers[i] + numbers[j] < target) i++;
            else if (numbers[i] + numbers[j] > target) j--;
            else {
                result.add(Arrays.asList(-target, numbers[i], numbers[j]));
                while (i < j && numbers[i] == numbers[i+1]) i++;
                while (i < j && numbers[j] == numbers[j-1]) j--;
                i++;
                j--;
            };
        }
    }
}