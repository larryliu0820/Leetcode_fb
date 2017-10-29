import java.util.*;

/**
 * Created by Larry Liu on 10/26/2017.
 * 210. Course Schedule II
 */
public class p210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[][] visited = new boolean[2][numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pre: prerequisites) {
            map.putIfAbsent(pre[0], new HashSet<>());
            map.get(pre[0]).add(pre[1]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited[0][i] && topoSort(map, visited, stack, i)) return new int[]{};
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) res[i] = stack.pop();
        return res;

    }

    private boolean topoSort(Map<Integer, Set<Integer>> map, boolean[][] visited, Stack<Integer> stack, int curr) {
        visited[0][curr] = true;
        if (map.containsKey(curr)) {
            visited[1][curr] = true;
            for (int neighbor : map.get(curr)) {
                if (visited[1][neighbor]) return true;
                if (!visited[0][neighbor] && topoSort(map, visited, stack, neighbor)) return true;
            }
            visited[1][curr] = false;
        }
        stack.push(curr);
        return false;
    }
}
