package leetcode.second;

import java.util.Arrays;

/**
 * 被围绕的区域
 * 遍历数组,找出所有和边界'O'相连的'O'并标记成'#'
 * 再次遍历数组,将'O'变成'X','#'还原成'O'
 *
 * @since 2020-5-14 Thursday 16:20
 */
public class Code_130_SurroundedArea {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        board[i][j] = '#';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

    public static void main(String[] args) {
        Code_130_SurroundedArea c = new Code_130_SurroundedArea();
        char[][] a = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        c.solve(a);
        System.out.println(Arrays.deepToString(a));
        char[][] b = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X'}
        };
        c.solve(b);
        System.out.println(Arrays.deepToString(b));
        char[][] d = {};
        c.solve(d);

    }
}
