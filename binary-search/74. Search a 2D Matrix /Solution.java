class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = (matrix.length * matrix[0].length) - 1;

        return binarySearch(matrix, target, 0, len, matrix[0].length);
    }

    boolean binarySearch(int[][] matrix, int target, int left, int right, int n) {
        if (left > right) {
            return false;
        }

        int mid = left + (right - left) / 2;

        if (matrix[mid/n][mid%n] == target)
            return true;
        else if (matrix[mid/n][mid%n] > target)
            return binarySearch(matrix, target, left, mid-1, n);
        else
            return binarySearch(matrix, target, mid + 1, right, n);
    }
}