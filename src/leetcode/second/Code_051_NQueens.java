package leetcode.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n皇后问题
 *
 * @since 2020-1-21 Tuesday
 */
public class Code_051_NQueens {
    List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(res, board, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, char[][] board, int row) {
        if (row == board.length) {
            res.add(convert(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (!valid(board, row, i)) {
                continue;
            }
            board[row][i] = 'Q';
            backtrack(res, board, row + 1);
            board[row][i] = '.';
        }
    }

    private boolean valid(char[][] board, int row, int col) {
        if (board[row][col] == 'Q') {
            return false;
        }
        for (int r = row - 1; r >= 0; r--) {
            if (board[r][col] == 'Q') {
                return false;
            }
        }
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        for (int r = row - 1, c = col + 1; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> convert(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] c : board) {
            res.add(new String(c));
        }
        return res;
    }

    public static void main(String[] args) {
        Code_051_NQueens c = new Code_051_NQueens();
        System.out.println(c.solveNQueens(4));
        System.out.println(c.solveNQueens(8));
    }
}
