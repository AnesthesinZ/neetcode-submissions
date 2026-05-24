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

        while (!q.isEmpty()) {
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                int[] point = q.poll();

                for (int[] dir : dirs) {
                    int r = point[0] + dir[0];
                    int c = point[1] + dir[1];

                    if (canVisit(grid, rows, cols, r, c)) {
                        q.add(new int[]{r, c});
                        grid[r][c] = grid[point[0]][point[1]] + 1;
                    }
                }
            }

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
