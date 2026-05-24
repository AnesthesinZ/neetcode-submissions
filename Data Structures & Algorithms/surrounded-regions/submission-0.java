class Solution {
    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') {
                q.add(new int[] {r, 0});
            } 
            if (board[r][cols - 1] == 'O') {
                q.add(new int[] {r, cols - 1});
            }
        }

        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') {
                q.add(new int[] {0, c});
            }

            if (board[rows - 1][c] == 'O') {
                q.add(new int[] {rows - 1, c});
            }
        }

        int[][] dirs = new int[][] {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

        while (!q.isEmpty()) {
            int[] point = q.poll();

            int r = point[0];
            int c = point[1];

            board[r][c] = 'T';

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || board[nr][nc] != 'O') {
                    continue;
                }

                q.add(new int[] {nr, nc});
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }


    }
}
