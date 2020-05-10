package leetcode.first;

import java.util.Arrays;

/**
 * 生命游戏
 *
 * @since 2020-5-10 23:06 - 00:04
 */
public class Code_289_GameOfLife {
    static void gameOfLife(int[][] board) {
        int[] m = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] n = {-1, 0, 1, 1, -1, -1, 0, 1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + m[k];
                    int y = j + n[k];
                    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) continue;
                    if ((board[x][y] & 1) == 1) cnt++;
                }
                if ((board[i][j] & 1) == 1) {
                    if (cnt == 2 || cnt == 3) {
                        board[i][j] = 0b11;
                    }
                } else if (cnt == 3) {
                    board[i][j] = 0b10;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(m);
        System.out.println(Arrays.deepToString(m));
    }
}
