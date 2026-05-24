class Solution {

    int[][] dirs = new int[][]{ {0, 1}, {1, 0}, {0, -1}, {-1, 0} }; 

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (checkIsland(grid, r, c, rows, cols)) {
                    islands++;
                }
            }
        }

        return islands;
    }

    public boolean checkIsland(char[][] grid, int r, int c, int rows, int cols) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != '1') {
            return false;
        }

        // expand from here;
        grid[r][c] = 'x';

        checkIsland(grid, r, c + 1, rows, cols);
        checkIsland(grid, r + 1, c, rows, cols);
        checkIsland(grid, r, c - 1, rows, cols);
        checkIsland(grid, r - 1, c, rows, cols);

        return true;
    }


}
