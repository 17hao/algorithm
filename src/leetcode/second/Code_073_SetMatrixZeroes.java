package leetcode.second;

import java.util.Arrays;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * @since 2019-12-28 Saturday
 */
public class Code_073_SetMatrixZeroes {
    static void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int columnLen = matrix[0].length;

        boolean rowFlag = false, columnFlag = false;
        for (int i = 0; i < columnLen; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                columnFlag = true;
                break;
            }
        }
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < columnLen; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < columnLen; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowFlag) {
            for (int i = 0; i < columnLen; i++) {
                matrix[0][i] = 0;
            }
        }
        if (columnFlag) {
            for (int i = 0; i < rowLen; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] p1 = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(p1);

        int[][] p2 = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes(p2);

        int[][] p3 = new int[][]{
                {1, 1, 2, 0},
                {3, 1, 5, 0},
                {1, 3, 1, 5}
        };
        setZeroes(p3);
        System.out.println(Arrays.deepToString(p1));
        System.out.println(Arrays.deepToString(p2));
        System.out.println(Arrays.deepToString(p3));
    }
}
