class MedianFinder {

    // minQ top smallest
    PriorityQueue<Integer> minQ = new PriorityQueue<>();
    // maxQ bot largest
    PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b)-> Integer.compare(b, a));

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        Integer right = minQ.peek();
        Integer left = maxQ.peek();

        if (right == null || num > right) {
            minQ.add(num);
            if (minQ.size() > maxQ.size() + 1) {
                maxQ.add(minQ.poll());
            }
        } else {
            maxQ.add(num);
            if (maxQ.size() > minQ.size()) {
                minQ.add(maxQ.poll());
            }
        }
    }
    
    public double findMedian() {
        if ((minQ.size() + maxQ.size()) % 2 == 0) {
            return (double)(minQ.peek() + maxQ.peek()) / 2;
        }
        return minQ.peek();
    }
}
