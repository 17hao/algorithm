package leetcode.first;

/**
 * 搜索二维矩阵
 *
 * @since 2020-3-26 Thursday 23:17
 */
public class Code_074_Search2DMatrix {
    static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int row = matrix.length, column = matrix[0].length;
        int len = row * column;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int element = matrix[mid / column][mid % column];
            if (element > target) {
                right = mid - 1;
            } else if (element < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(m, 13));
        System.out.println(searchMatrix(m, 3));
    }
}
