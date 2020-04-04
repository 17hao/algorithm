package leetcode.third;

/**
 * 单词搜索
 *
 * @since 2020-4-4 Saturday 22:34 - 23:06
 */
public class Code_079_WordSearch {
    static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        if (word.length() == 0) return true;
        int rows = board.length, columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == word.charAt(0) && helper(i, j, 0, new boolean[rows][columns], board, word))
                    return true;
            }
        }
        return false;
    }

    private static boolean helper(int i, int j, int index, boolean[][] track, char[][] board, String word) {
        if (index == word.length()) return true;
        if (i < 0 ||
                i >= board.length ||
                j < 0 ||
                j >= board[0].length ||
                track[i][j] ||
                word.charAt(index) != board[i][j]) return false;
        track[i][j] = true;
        if (helper(i + 1, j, index + 1, track, board, word) ||
                helper(i - 1, j, index + 1, track, board, word) ||
                helper(i, j + 1, index + 1, track, board, word) ||
                helper(i, j - 1, index + 1, track, board, word)) return true;
        track[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "abc"));
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "ABCB"));
    }
}
