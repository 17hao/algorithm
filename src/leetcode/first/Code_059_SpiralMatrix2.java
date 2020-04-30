package leetcode.first;

import java.util.Arrays;

/**
 * 螺旋矩阵2
 *
 * @since 2020-4-30 13:57 - 14:09
 */
public class Code_059_SpiralMatrix2 {
    static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1, target = n * n;
        while (num <= target) {
            for (int i = l; i <= r; i++) {
                res[t][i] = num++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                res[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                res[b][i] = num++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                res[i][l] = num++;
            }
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(0)));
        System.out.println(Arrays.deepToString(generateMatrix(1)));
        System.out.println(Arrays.deepToString(generateMatrix(3)));
        System.out.println(Arrays.deepToString(generateMatrix(4)));
        System.out.println(Arrays.deepToString(generateMatrix(5)));
    }
}
