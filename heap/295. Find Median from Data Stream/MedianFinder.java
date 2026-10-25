class MedianFinder {

    PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()) {
            leftMaxHeap.offer(num);
        } else {
            rightMinHeap.offer(num);
        }

        if (leftMaxHeap.size() > rightMinHeap.size()+1) {
            rightMinHeap.offer(leftMaxHeap.poll());
        } else if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.offer(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            double mean = ((double) leftMaxHeap.peek() + (double) rightMinHeap.peek()) / 2;
            return mean;
        }

        return leftMaxHeap.peek();
    }
}