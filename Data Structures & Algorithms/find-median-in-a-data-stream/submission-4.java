class MedianFinder {
    // max heap (left side)
    private PriorityQueue<Integer> small;
    // min heap (right side)
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        large = new PriorityQueue<>(); // min heap
    }

    public void addNum(int num) {
        small.offer(num);

        // ensure ordering: max(small) <= min(large)
        large.offer(small.poll());

        // balance sizes
        if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        }
        return (small.peek() + large.peek()) / 2.0;
    }
}