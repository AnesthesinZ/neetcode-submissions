class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rowCount= board.length;
        int colCount = board[0].length;

        int rows[][] = new int[9][9];
        int cols[][] = new int[9][9];
        int squares[][] = new int[9][9];

        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                if (board[r][c] != '.') {

                    int targetValue = board[r][c] - '0' - 1;

                    if (rows[r][targetValue] == 1) {
                        return false;
                    } else {
                        rows[r][targetValue] = 1;
                    }

                    if (cols[c][targetValue] == 1) {
                        return false;
                    } else {
                        cols[c][targetValue] = 1;
                    }

                    int squareId = r / 3 * 3 + c / 3;
                    if (squares[squareId][targetValue] == 1) {
                        return false;
                    } else {
                        squares[squareId][targetValue] = 1;
                    }
                }
            }
        }

        return true;
    }
}
