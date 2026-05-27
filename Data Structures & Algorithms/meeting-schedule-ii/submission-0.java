/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {    
        if (intervals.size() == 0) {
            return 0;
        }

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b)-> Integer.compare(a.end, b.end));

        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);

            if (!pq.isEmpty() && pq.peek().end <= cur.start) {
                pq.poll();
            }
            pq.add(cur);
        }

        return pq.size();
    }
}
