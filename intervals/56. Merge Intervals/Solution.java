class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] res = new int[intervals.length][2];

        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        int index = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= prevEnd) {
                prevEnd = Math.max(intervals[i][1], prevEnd);
            } else {
                res[index++] = new int[] {prevStart, prevEnd};
                prevStart = intervals[i][0];
                prevEnd = intervals[i][1];
            }
        }
        res[index++] =  new int[] {prevStart, prevEnd};

        return Arrays.copyOf(res, index);
    }
}