package leetcode.second;

import java.util.HashSet;

/**
 * 有效数独
 *
 * @since 2019-12-26 Thursday 15:25
 */
public class Code_036_ValidSudoku {
    static boolean isValidSudoku(char[][] board) {
        int rowLen = 9, columnLen = 9;
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < columnLen; j++) {
                if (board[i][j] != '.') {
                    int boxIndex = (i / 3) * 3 + j / 3;
                    HashSet<Character> r = rows[i];
                    HashSet<Character> c = columns[j];
                    HashSet<Character> b = boxes[boxIndex];
                    if (r.contains(board[i][j]) || c.contains(board[i][j]) || b.contains(board[i][j])) {
                        return false;
                    } else {
                        r.add(board[i][j]);
                        c.add(board[i][j]);
                        b.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] sudoku = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '4', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(sudoku));
    }
}
