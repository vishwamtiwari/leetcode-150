class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];

        int newIntervalStart = newInterval[0];
        int newIntervalEnd = newInterval[1];
        int index = 0;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newIntervalStart) {
                res[index++] = new int[] {intervals[i][0], intervals[i][1]};
            } else if (intervals[i][0] > newIntervalEnd) {
                // Inserting the merged interval first
                res[index++] = new int[] {newIntervalStart, newIntervalEnd};

                // Point newInterval to current so the next ones pass through normally
                newIntervalStart = intervals[i][0];
                newIntervalEnd = intervals[i][1];
            }
            else {
                // Merge without inserting
                newIntervalStart = Math.min(newIntervalStart, intervals[i][0]);
                newIntervalEnd = Math.max(newIntervalEnd, intervals[i][1]);
            }
        }

        // Insert the final remaining interval after loop ends
        res[index++] = new int[] {newIntervalStart, newIntervalEnd};

        return Arrays.copyOf(res, index);
    }
}