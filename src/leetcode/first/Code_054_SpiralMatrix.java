package leetcode.first;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @since 2020-1-2 Thursday
 */
public class Code_054_SpiralMatrix {
    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int u = 0;
        int d = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        while (true) {
            for (int i = l; i <= r; i++) {
                res.add(matrix[u][i]);
            }
            if (++u > d) break;
            for (int i = u; i <= d; i++) {
                res.add(matrix[i][r]);
            }
            if (--r < l) break;
            for (int i = r; i >= l; i--) {
                res.add(matrix[d][i]);
            }
            if (--d < u) break;
            for (int i = d; i >= u; i--) {
                res.add(matrix[i][l]);
            }
            if (++l > r) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(m));
        //System.out.println(spiralOrder(new int[][]{}));
    }
}
