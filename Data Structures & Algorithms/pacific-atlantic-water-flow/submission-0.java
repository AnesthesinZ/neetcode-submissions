class Solution {

    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> res = new ArrayList<>();

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pv = new boolean[rows][cols];
        boolean[][] av = new boolean[rows][cols];

        Queue<int[]> q = new LinkedList<>();

        for (int c = 0; c < cols; c++) {
            q.add(new int[] {0, c});
        }

        for (int r = 0; r < rows; r++) {
            q.add(new int[] {r, 0});
        }

        bfs(heights, pv, q, rows, cols);

        for (int c = 0; c < cols; c++) {
            q.add(new int[] {rows - 1, c});
        }

        for (int r = 0; r < rows; r++) {
            q.add(new int[] {r, cols - 1});
        }

        bfs(heights, av, q, rows, cols);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (av[r][c] && pv[r][c]) {
                    res.add(List.of(r, c));
                }
            }
        }

        return res;
    }

    public void bfs(int[][] heights, boolean[][] visited, Queue<int[]> q, int rows, int cols) {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0];
            int c = point[1];

            visited[r][c] = true;

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || 
                    visited[nr][nc] || heights[nr][nc] < heights[r][c]) {
                    continue;
                }

                q.add(new int[] {nr, nc});
            }
        }
    }
}
