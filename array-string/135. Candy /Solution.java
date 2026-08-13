class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int res = len;
        int i = 1;

        while (i < len) {
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }

            int peak = 0;
            while (i < len && ratings[i] > ratings[i - 1]) {
                peak++;
                res += peak;
                i++;
            }

            int dip = 0;
            while (i < len && ratings[i] < ratings[i - 1]) {
                dip++;
                res += dip;
                i++;
            }

            res -= Math.min(peak, dip);
        }
        return res;

        /*
        //Two-Pass Greedy approach
        int len = ratings.length;
        int[] leftToRight = new int[len];
        Arrays.fill(leftToRight, 1);
        int[] rightToLeft = new int[len];
        Arrays.fill(rightToLeft, 1);

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) leftToRight[i] = Math.max(leftToRight[i], leftToRight[i - 1] + 1);
        }

        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) rightToLeft[i] = Math.max(rightToLeft[i], rightToLeft[i + 1] + 1);
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.max(leftToRight[i], rightToLeft[i]);
        }

        return res;
        */
    }
}