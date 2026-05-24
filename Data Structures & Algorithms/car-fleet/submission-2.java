class Solution {

    class Pair {
        int pos;
        int speed;
        double time;

        public Pair(int pos, int speed, int target) {
            this.pos = pos;
            this.speed = speed;
            this.time = (double)(target - pos) / speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {

        if (position.length == 0) {
            return 0;
        }

        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            pairs.add(new Pair(position[i], speed[i], target));
        }

        Collections.sort(pairs, (a, b)-> Integer.compare(b.pos, a.pos));

        Stack<Double> timeStack = new Stack<>();
        timeStack.push(pairs.get(0).time);

        for (int i = 1; i < pairs.size(); i++) {
            Double oldTime = timeStack.peek();
            Double curTime = pairs.get(i).time;

            if (curTime > oldTime) {
                timeStack.add(curTime);
            }
        }

        return timeStack.size();
    }
}
