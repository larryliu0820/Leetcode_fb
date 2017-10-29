import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Larry Liu on 10/28/2017.
 * 286. Walls and Gates
 */
public class p286 {
    class Point {
        int row, col, step;
        Point(int r, int c, int s) {
            row = r;
            col = c;
            step = s;
        }
    }
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        int M = rooms.length, N = rooms[0].length;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (rooms[i][j] == 0) queue.offer(new Point(i, j, 0));
            }
        }
        int[][] incs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            rooms[curr.row][curr.col] = Math.min(rooms[curr.row][curr.col], curr.step);
            visited[curr.row][curr.col] = true;
            for (int[] inc : incs) {
                if (isValid(rooms, visited,curr.row + inc[0], curr.col + inc[1]))
                    queue.offer(new Point(curr.row + inc[0], curr.col + inc[1], curr.step + 1));
            }
        }
    }
    private boolean isValid(int[][] rooms, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length) return false;
        return rooms[row][col] != -1 && !visited[row][col];
    }
}
