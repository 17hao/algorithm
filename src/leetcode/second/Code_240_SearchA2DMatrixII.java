package leetcode.second;

/**
 * 搜索2维矩阵II
 *
 * @since 2020-4-17 Friday 22:03
 */
public class Code_240_SearchA2DMatrixII {
    static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix == null) return false;
        int m = 0, n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0) {
            if (matrix[m][n] == target) return true;
            else if (matrix[m][n] > target) n--;
            else m++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}};
        System.out.println(searchMatrix(matrix, 1));
        System.out.println(searchMatrix(matrix, 5));
        System.out.println(searchMatrix(matrix, 100));
    }
}
