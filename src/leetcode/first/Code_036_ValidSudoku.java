package leetcode.first;

import java.util.HashMap;

/**
 * 有效数独
 *
 * @since 2019-12-19 Thursday
 */
public class Code_036_ValidSudoku {
    static boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] subSudokues = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            columns[i] = new HashMap<>();
            rows[i] = new HashMap<>();
            subSudokues[i] = new HashMap<>();
        }
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                char c = board[column][row];
                if (c != '.') {
                    int num = c;
                    int subSudokuIndex = row / 3 + (column / 3) * 3;
                    columns[column].put(num, columns[column].getOrDefault(num, 0) + 1);
                    rows[row].put(num, rows[row].getOrDefault(num, 0) + 1);
                    subSudokues[subSudokuIndex].put(num, subSudokues[subSudokuIndex].getOrDefault(num, 0) + 1);
                    if (columns[column].get(num) > 1 || rows[row].get(num) > 1 || subSudokues[subSudokuIndex].get(num) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] s = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '7', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(s));
    }
}
