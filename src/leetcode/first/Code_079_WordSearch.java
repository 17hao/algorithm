package leetcode.first;

/**
 * 单词搜索
 *
 * @since 2020-1-4 16:23
 */
public class Code_079_WordSearch {
    boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && backtrack(i, j, 0, visited, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int i, int j, int index, boolean[][] visited, char[][] board, String word) {
        if (index == word.length()) return true;
        if (i >= board.length ||
                i < 0 ||
                j >= board[0].length ||
                j < 0 ||
                visited[i][j] ||
                board[i][j] != word.charAt(index)) return false;

        visited[i][j] = true;
        if (backtrack(i - 1, j, index + 1, visited, board, word) ||
                backtrack(i, j - 1, index + 1, visited, board, word) ||
                backtrack(i + 1, j, index + 1, visited, board, word) ||
                backtrack(i, j + 1, index + 1, visited, board, word)) return true;
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'a', 'b', 'c'},
                {'q', 'e', 'w'},
                {'z', 'x', 'c'}};
        System.out.println(new Code_079_WordSearch().exist(board, "abc"));
        System.out.println(new Code_079_WordSearch().exist(board, "cxq"));
    }
}
