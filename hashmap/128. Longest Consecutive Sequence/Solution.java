class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        HashSet<Integer> set = new HashSet<>();
        for (int n: nums) set.add(n);

        int max = 0;
        for (int n: set) {
            if (!set.contains(n - 1)) {
                int current = n, streak = 1;
                while (set.contains(current + 1)) {
                    streak++;
                    current++;
                }
                max = Math.max(max, streak);
            }
        }
        return max;
    }
}