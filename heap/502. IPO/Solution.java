class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[] {capital[i], profits[i]});
        }

        //sort based on capital
        list.sort((a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (k > 0) {
            while (i < n && list.get(i)[0] <= w) {
                pq.offer(list.get(i)[1]);
                i++;
            }

            if (pq.isEmpty())
                break;

            w += pq.poll();

            k--;
        }

        return w;
    }
}