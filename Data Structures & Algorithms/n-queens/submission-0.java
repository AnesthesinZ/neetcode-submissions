class Solution {

        List<List<String>> res = new ArrayList<>();

        int[][] dirs = new int[][] { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

        boolean[] rows;
        boolean[] cols;
        boolean[] diag;
        boolean[] antiDiag;

        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            rows = new boolean[n];
            cols = new boolean[n];
            diag = new boolean[2*n-1];
            antiDiag = new boolean[2*n-1];

            backtrack(board, 0, n);
            return res;
        }

        public void backtrack(char[][] board, int r, int n) {
            if (r == n) {
                saveSolution(board, n);
                return;
            }

            for (int c = 0; c < n; c++) {
                if (validPlacement(board, r, c, n)) {
                    placeQueue(board, r, c, n);
                    backtrack(board, r + 1, n);
                    removeQueue(board, r, c, n);
                }
            }
        }

        public void saveSolution(char[][] board, int n) {
            List<String> subset = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                String s = "";
                for (int c = 0; c < n; c++) {
                    if (board[r][c] == 'Q') {
                        s = s + "Q";
                    } else {
                        s = s + '.';
                    }
                }
                subset.add(s);
            }
            res.add(subset);
        }

        public void placeQueue(char[][] board, int r, int c, int n) {
            rows[r] = true;
            cols[c] = true;
            diag [r - c + n - 1] = true;
            antiDiag [r + c] = true;
            board[r][c] = 'Q';
        }

        public void removeQueue(char[][] board, int r, int c, int n) {
            rows[r] = false;
            cols[c] = false;
            diag [r - c + n - 1] = false;
            antiDiag [r + c] = false;
            board[r][c] = '.';
        }

        public boolean validPlacement(char[][] board, int r, int c, int n) {
            if (r < 0 || r >= n || c < 0 || c >= n || board[r][c] == 'Q') {
                return false;
            }

            if (rows[r] || cols[c] || diag [r - c + n - 1] || antiDiag [r + c]) {
                return false;
            }

            return true;
        }

    }