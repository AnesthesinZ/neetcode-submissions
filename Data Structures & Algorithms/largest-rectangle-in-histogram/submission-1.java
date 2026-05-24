class Solution {

    class Pair{
        int idx;
        int height;
        public Pair (int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public int largestRectangleArea(int[] heights) {
        // note: a rectangle can only grow up to a height that's smaller than it. 
        if (heights.length == 0) {
            return 0;
        }

        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(0, heights[0]));
        int maxSquare = heights[0];

        for (int i = 1; i < heights.length; i++) {
            int height = heights[i];
            int start = i;
            
            while (!stack.isEmpty() && stack.peek().height > height) {
                Pair top = stack.pop();
                start = top.idx;
                maxSquare = Math.max(maxSquare, (i - top.idx) * top.height);
            }
            stack.add(new Pair(start, heights[i]));
        }

        while (!stack.isEmpty()) {
            Pair top = stack.pop();
            maxSquare = Math.max(maxSquare, (heights.length - top.idx) * top.height);
        }

        return maxSquare;
    }
}
