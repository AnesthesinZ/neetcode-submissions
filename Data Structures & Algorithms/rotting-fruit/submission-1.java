class Solution {
    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int totalFresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    q.add(new int[] {r, c});
                } else if (grid[r][c] == 1) {
                    totalFresh ++;
                }
            }
        }

        if (totalFresh == 0) {
            return 0;
        }

        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int time = -1;

        while (!q.isEmpty()) {
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                int[] point = q.poll();

                for (int[] dir : dirs) {
                    int r = point[0] + dir[0];
                    int c = point[1] + dir[1];

                    if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != 1) {
                        continue;
                    }

                    if (grid[r][c] == 1) {
                        totalFresh--;
                        grid[r][c] = 2;
                        q.add(new int[] {r, c});
                    }
                }
            }
            time ++;
        }

        if (totalFresh > 0) {
            return -1;
        }
        return time;
    }
}
