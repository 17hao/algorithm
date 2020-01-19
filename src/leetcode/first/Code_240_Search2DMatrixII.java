package leetcode.first;

/**
 * 搜索二维矩阵2
 *
 * @since 2020-1-15
 */
public class Code_240_Search2DMatrixII {
    static boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        if (len == 0) return false;
        int row = 0, column = matrix[0].length - 1;
        while (row < len && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(m, 5));
        System.out.println(searchMatrix(m, 30));
        System.out.println(searchMatrix(m, 40));
    }
}
