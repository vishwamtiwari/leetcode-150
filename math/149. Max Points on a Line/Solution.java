class Solution {

    /*
     * Bruteforce - O(n^3)
     * Comparisn by slope
     */
//    public int maxPoints(int[][] points) {
//        int n = points.length;
//        if (n == 1)
//            return 1;
//
//        int result = 0;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                int count = 2;
//
//                int dx = points[j][0] - points[i][0]; //x2-x1
//                int dy = points[j][1] - points[i][1]; //y2-y1
//
//                for (int k = 0; k < n; k++) {
//                    if (k != i && k != j) {
//                        int dx_ = points[k][0] - points[i][0]; //x3-x1
//                        int dy_ = points[k][1] - points[i][1]; //y3-y1
//
//                        if (dy * dx_ == dy_ * dx)
//                            count++;
//                    }
//                }
//
//                result = Math.max(result, count);
//            }
//        }
//        return result;
//    }


    // O(n^2)
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1)
            return 1;

        int result = 0;

        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> map = new HashMap<>();

            for (int j = i+1; j < n; j++) {
                if (j == i)
                    continue;

                double dy = points[j][1] - points[i][1]; //y2-y1
                double dx = points[j][0] - points[i][0]; //x2-x1

                double gcd = Math.abs(gcd(dy, dx));
                String key = (dx/gcd) + "_" + (dy/gcd);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            for (String key: map.keySet()) {
                result = Math.max(result, map.get(key) + 1);
            }
        }

        return result;
    }

    double gcd(double dy, double dx) {
        if (dx == 0)
            return dy;

        return gcd(dx, dy % dx);
    }
}