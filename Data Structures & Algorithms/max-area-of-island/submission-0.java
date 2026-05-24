class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int maxSize = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int islandSize = checkIslandSize(grid, r, c, rows, cols);
                maxSize = Math.max(maxSize, islandSize);
            }
        }

        return maxSize;
    }

    public int checkIslandSize(int[][] grid, int r, int c, int rows, int cols) {
        int size = 0;
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != 1) {
            return size;
        }

        // expand from here;
        grid[r][c] = -1;

        return checkIslandSize(grid, r, c + 1, rows, cols) + 
        checkIslandSize(grid, r + 1, c, rows, cols) + 
        checkIslandSize(grid, r, c - 1, rows, cols) +
        checkIslandSize(grid, r - 1, c, rows, cols) + 1;
    }
}
