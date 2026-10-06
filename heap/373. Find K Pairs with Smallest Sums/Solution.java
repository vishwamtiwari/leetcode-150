class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }

        int m = nums1.length;
        int n = nums2.length;

        // Min-heap stores int[]{i, j}, comparing by sum: nums1[i] + nums2[j]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]])
        );

        // 1. Seed heap with the first column: (i, 0) for i up to min(m, k)
        int initialRows = Math.min(m, k);
        for (int i = 0; i < initialRows; i++) {
            pq.offer(new int[]{i, 0});
        }

        // 2. Extract smallest and advance ONLY along the same row (j -> j + 1)
        while (k > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            k--;

            int i = curr[0];
            int j = curr[1];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            // Advance to next element in row i
            if (j + 1 < n) {
                pq.offer(new int[]{i, j + 1});
            }
        }

        return result;
    }
}