package leetcode;

/**
 * @author 17hao
 * finished on 2019-4-15 23:00
 */
public class Code_059_SpiralMatrixII {
    /*
      1, 2, 3
      8, 9, 4
      7, 6, 5
    1 , 2, 3,4
    12,13,14,5
    11,16,15,6
    10, 9, 8,7
     */
    private static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {

        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] res = generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(res[i][j]);
            }
            System.out.println("\n");
        }
    }
}
