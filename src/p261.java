import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Larry Liu on 10/23/2017.
 * 261. Graph Valid Tree
 */
public class p261 {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge: edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        if (dfs(map, visited, 0, -1)) return false;
        for (int i = 0; i < n; i++) if (!visited[i]) return false;
        return true;

    }

    private boolean dfs(Map<Integer, Set<Integer>> map, boolean[] visited, int curr, int parent) {
        visited[curr] = true;
        if (map.containsKey(curr)) {
            for (int neighbor : map.get(curr)) {
                if (neighbor != parent && visited[neighbor]) return true;
                else if (!visited[neighbor]) {
                    if (dfs(map, visited, neighbor, curr)) return true;
                }
            }
        }
        return false;
    }
}
