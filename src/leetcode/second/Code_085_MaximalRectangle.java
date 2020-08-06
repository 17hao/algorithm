package leetcode.second;

/**
 * 最大子矩形
 * 
 * @since 2020-8-6 Thursday 13:53 - 14:28
 */
public class Code_085_MaximalRectangle {
    static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] height = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int m = 0;
                if (matrix[i][j] == '0') {
                    height[i][j] = 0;
                    continue;
                } else {
                    int tmpI = i;
                    while (tmpI < matrix.length && matrix[tmpI][j] == '1') {
                        m++;
                        tmpI++;
                    }
                    height[i][j] = m;
                }
            }
            int tmpRes = 0;
            for (int k = 0; k < matrix[0].length; k++) {
                if (height[i][k] == 0) {
                    res = Math.max(res, tmpRes);
                    tmpRes = 0;
                    continue;
                } else {
                    int min = Integer.MAX_VALUE;
                    int base = k;
                    while (base < matrix[0].length && height[i][base] != 0) {
                        min = Math.min(min, height[i][base]);
                        base++;
                        tmpRes = Math.max(((base - k) * min), tmpRes);
                    }
                    res = Math.max(res, tmpRes);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } }));
        System.out.println(maximalRectangle(new char[][] { { '1', '1', '1', '1', '1', '1', '1', '1' },
                { '1', '1', '1', '1', '1', '1', '1', '0' }, { '1', '1', '1', '1', '1', '1', '1', '0' },
                { '1', '1', '1', '1', '1', '0', '0', '0' }, { '0', '1', '1', '1', '1', '0', '0', '0' } }));
    }
}

// 4 0 3 0 0
// 3 0 2 3 2
// 2 1 1 1 1
// 1 0 0 1 0

// 4 0 3 0 0
// 3 0 3 2 2
// 2 1 1 1 1
// 1 0 0 1 0