class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();

        int i = 0;
        int len = nums.length;
        while (i < len) {
            int start = nums[i];

            while (i + 1 < len && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            if (start == nums[i]) {
                summary.add(String.valueOf(start));
            } else {
                summary.add(start + "->" + nums[i]);
            }
            i++;
        }
        return summary;
    }
}