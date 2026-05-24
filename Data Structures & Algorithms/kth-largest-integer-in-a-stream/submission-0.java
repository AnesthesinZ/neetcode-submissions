class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int limit;

    public KthLargest(int k, int[] nums) {
        this.limit = k;
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if (pq.size() > this.limit) {
            pq.poll();
        }

        return pq.peek();
    }
}
