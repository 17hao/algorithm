package leetcode.third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N queens
 * 
 * @since 2020-7-16 Thursday  18:40 - 19:30
 */
public class Code_051_NQueens {
    List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        List<List<String>> res = new ArrayList<>();
        dfs(res, board, 0);
        return res;
    }

    private void dfs(List<List<String>> res, char[][] board, int n) {
        if (board.length == n) {
            res.add(convert(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (!valid(board, n, i)) {
                continue;
            }
            board[n][i] = 'Q';
            dfs(res, board, n + 1);
            board[n][i] = '.';
        }
    }

    private boolean valid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // for (int i = row + 1, j = col - 1; i < board.length && j >= 0; i++, j--) {
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> convert(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            StringBuilder builder = new StringBuilder();
            for (char c : row) {
                builder.append(c);
            }
            res.add(builder.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        Code_051_NQueens c = new Code_051_NQueens();
        System.out.println(c.solveNQueens(3));
        System.out.println(c.solveNQueens(4));
    }
}