class Solution {

    class Point {
        double dist;
        int[] point;

        public Point(double dist, int[] point) {
            this.dist = dist;
            this.point = point;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            double dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            pq.add(new Point(dist, point));
            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.stream().map(p-> p.point).toArray(int[][]::new);
    }


}
