class Solution {


    int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (backtrack(board, word, rows, cols, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean backtrack(char[][] board, String word, int rows, int cols, int r, int c, int i) {

        if (i >= word.length() || 
            r < 0 || r >= rows || c < 0 || c >= cols || 
            board[r][c] != word.charAt(i)) {
            return false;
        }

        if (board[r][c] == word.charAt(i) && i == word.length() - 1) {
            return true;
        }

        boolean res = false;
        for (int[] dir : directions) {
            char temp = board[r][c];
            board[r][c] = '*';
            res = res || backtrack(board, word, rows, cols, r + dir[0], c + dir[1], i + 1);
            board[r][c] = temp;
        }

        return res;
    }
}
