class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) return 1;

        int arrows = points.length;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int prevEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= prevEnd)  {
                arrows--;
                prevEnd = Math.min(prevEnd, points[i][1]);
            }
            else prevEnd = points[i][1];
        }
        return arrows;
    }
}