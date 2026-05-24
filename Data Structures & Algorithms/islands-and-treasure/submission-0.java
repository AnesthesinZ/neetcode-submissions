class Solution {

    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    q.add(new int[] {r, c});
                }
            }
        }

        int dist = 0;

        while (!q.isEmpty()) {
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                int[] point = q.poll();

                grid[point[0]][point[1]] = Math.min(dist, grid[point[0]][point[1]]);

                for (int[] dir : dirs) {
                    if (canVisit(grid, rows, cols, point[0] + dir[0], point[1] + dir[1])) {
                        q.add(new int[]{point[0] + dir[0], point[1] + dir[1]});
                    }
                }
            }

            dist ++;
        }
    }

    boolean canVisit(int[][] grid, int rows, int cols, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || 
            grid[r][c] != 2147483647
        ) {
            return false;
        }

        return true;
    }
}
