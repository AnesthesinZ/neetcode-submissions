class Solution {
    public int swimInWater(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> 
            Integer.compare(grid[a[0]][a[1]], grid[b[0]][b[1]])
        );

        pq.add(new int[] {0, 0});

        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;

        while (!pq.isEmpty()) {

            int[] point = pq.poll();
            int r = point[0];
            int c = point[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc]) {
                    continue;
                }

                visited[r][c] = true;

                if (grid[nr][nc] < grid[r][c]) {
                    grid[nr][nc] = grid[r][c];
                }

                pq.add(new int[]{nr, nc});
            }


        }

        return grid[rows-1][cols-1];
    }
}
