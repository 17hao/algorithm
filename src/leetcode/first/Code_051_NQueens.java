package leetcode.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n皇后问题
 *
 * @since 2020-1-18 Saturday
 */
public class Code_051_NQueens {
    List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] b = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(b[i], '.');
        }
        backtrack(res, b, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, char[][] board, int row) {
        if (board.length == row) {
            res.add(convert(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            backtrack(res, board, row + 1);
            board[row][col] = '.';
        }
    }

    private List<String> convert(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] chars : board) {
            res.add(String.valueOf(chars));
        }
        return res;
    }

    private boolean isValid(char[][] board, int row, int col) {
        int len = board.length;
        for (char[] chars : board) {
            if (chars[col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < len; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Code_051_NQueens c = new Code_051_NQueens();
        System.out.println(c.solveNQueens(4));
        System.out.println(c.solveNQueens(8).size());
    }
}
