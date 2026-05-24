class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // from -> to, price
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            adjList.computeIfAbsent(from, key->new ArrayList<>()).add(new int[] {to, price});
        }

        // price, city, stop
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        pq.add(new int[] {0, src, 0});

        while (!pq.isEmpty()) {
            int[] stopInfo = pq.poll();

            int accPrice = stopInfo[0];
            int curCity = stopInfo[1];
            int accStop = stopInfo[2];

            if (curCity == dst && accStop - 1<= k) {
                return accPrice;
            }

            if (curCity != dst && accStop > k) {
                continue;
            }

            for (int[] destInfo : adjList.getOrDefault(curCity, Collections.emptyList())) {

                int destCity = destInfo[0];
                int cost = destInfo[1];

                pq.add(new int[] {
                    accPrice + cost,
                    destCity,
                    accStop + 1
                });
            }

        }

        return -1;
    }
}
