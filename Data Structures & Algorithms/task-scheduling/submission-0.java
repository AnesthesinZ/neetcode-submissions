class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] slots = new int[26];
        for (char task : tasks) {
            slots[task - 'A']++;
        }

        PriorityQueue<Integer> countHeap = new PriorityQueue<>(
            (a, b)-> Integer.compare(b, a)
        );
        Queue<int[]> coolDownQueue = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            if (slots[i] > 0) {
                countHeap.add(slots[i]);
            }
        }

        int time = 0;
        while (!countHeap.isEmpty() || !coolDownQueue.isEmpty()) {
            time ++;
            if (countHeap.isEmpty()) {
                time = coolDownQueue.peek()[1];
            } else {
                int count = countHeap.poll();
                count--;
                if (count > 0) {
                    coolDownQueue.add(new int[] {count, time + n});
                }
            }

            if (!coolDownQueue.isEmpty() && time == coolDownQueue.peek()[1]) {
                countHeap.add(coolDownQueue.poll()[0]);
            }
        }

        return time;
    }
}
