class Solution {
    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int longestPathLength = 0;

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Integer[][] pathLength = new Integer[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(matrix, rows, cols, r, c, pathLength);
            }
        }
        return longestPathLength;
    }

    public int dfs(int[][] matrix, int rows, int cols, int r, int c, Integer[][] pathLength) {
        if (pathLength[r][c] != null) {
            return pathLength[r][c];
        }

        pathLength[r][c] = 1;

        int cur = matrix[r][c];
        int maxPath = 1;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || 
                matrix[nr][nc] <= cur) {
                continue;
            }
            maxPath = Math.max(dfs(matrix, rows, cols, nr, nc, pathLength) + 1, maxPath);
        }

        pathLength[r][c] = maxPath;
        longestPathLength = Math.max(longestPathLength, maxPath);
        return maxPath;
    }
}
