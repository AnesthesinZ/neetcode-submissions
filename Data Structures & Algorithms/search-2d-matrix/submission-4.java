class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int l = 0;
        int r = row - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (matrix[mid][0] > target) {
                r = mid - 1;
            } else if (matrix[mid][0] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }

        int targetRow = (l + r) / 2;

        l = 0;
        r = col - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (matrix[targetRow][mid] > target) {
                r = mid - 1;
            } else if (matrix[targetRow][mid] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
