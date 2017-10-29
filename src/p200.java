import java.util.*;

/**
 * Created by mengwliu on 10/28/17
 * 200. Number of Islands
 */
public class p200 {
    class UF {
        int[] father;
        int[] size;
        int count;
        UF(int t) {
            father = new int[t];
            size = new int[t];
            count = t;
            for (int i = 0; i < t; i++) father[i] = i;
        }
        void union(int i, int j) {
            int f1 = find(i);
            int f2 = find(j);
            if (f1 == f2) return;
            if (size[f1] < size[f2]) {
                father[f1] = f2;
                size[f2] += size[f1];
            } else {
                father[f2] = f1;
                size[f1] += size[f2];
            }
            count--;
        }

        int find(int i) {
            while (father[i] != i) {
                father[i] = father[father[i]];
                i = father[i];
            }
            return i;
        }

        boolean connected(int i, int j) {
            int f1 = find(i);
            int f2 = find(j);
            return (f1 == f2);
        }
    }
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        UF uf = new UF(grid.length * grid[0].length);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int curr = i * grid[0].length + j;
                if (i > 0 && grid[i-1][j] == grid[i][j]) {
                    uf.union(curr, curr - grid[0].length);
                }
                if (j > 0 && grid[i][j-1] == grid[i][j]) {
                    uf.union(curr, curr - 1);
                }
            }
        }
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') continue;
                int curr = i * grid[0].length + j;
                int root = uf.find(curr);
                if (!roots.contains(root)) roots.add(root);
            }
        }
        return roots.size();
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isValid(grid, visited, i, j)) {
                    bfs(grid, visited, i, j);
                    count ++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] board, boolean[][] visited, int row, int col) {

        int[] start = new int[]{row, col};
        int[][] incs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            visited[curr[0]][curr[1]] = true;
            for (int[] inc: incs) {
                int[] next = new int[]{curr[0] + inc[0], curr[1] + inc[1]};
                if (isValid(board, visited, next[0], next[1])) queue.offer(next);
            }
        }
    }

    private boolean isValid(char[][] board, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        return (board[row][col] == '1' && !visited[row][col]);
    }

    public static void main(String[] args) {
        p200 sol = new p200();
        int res = sol.numIslands2(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}});

        System.out.println(res);
    }
}
