package leetcode.second;

import java.util.Arrays;

/**
 * 生命游戏
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 *
 * @since 2020-5-14 Thursday 17:00 - 17:27
 */
public class Code_289_LifeGame {
    static public void gameOfLife(int[][] board) {
        if (board.length == 0) return;
        int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    int a = i + x[k], b = j + y[k];
                    if (a < 0 || b < 0 || a >= m || b >= n) continue;
                    if ((board[a][b] & 1) == 1) cnt++;
                }
                if ((board[i][j] & 1) == 1) {
                    if (cnt < 2 || cnt > 3) {
                        board[i][j] = 0b01;
                    } else {
                        board[i][j] = 0b11;
                    }
                } else if (cnt == 3) {
                    board[i][j] = 0b10;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};
        gameOfLife(a);
        System.out.println(Arrays.deepToString(a));
    }
}
