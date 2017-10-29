/**
 * Created by Larry Liu on 10/26/2017.
 * 79. Word Search
 */
public class p079 {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, visited, i, j, 0, word)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int row, int col, int index, String target) {
        if (index == target.length()-1) return true;
        visited[row][col] = true;
        int[][] incs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] inc: incs) {
            int nrow = row + inc[0];
            int ncol = col + inc[1];
            if (isValid(board, nrow, ncol) && !visited[nrow][ncol]) {
                if (target.charAt(index+1) == board[nrow][ncol])
                    if (dfs(board, visited, nrow, ncol, index+1, target)) return true;
            }
        }
        visited[row][col] = false;
        return false;
    }

    private boolean isValid(char[][] board, int row, int col) {
        return (row >= 0 && row < board.length && col >= 0 && col < board[0].length);
    }
}
