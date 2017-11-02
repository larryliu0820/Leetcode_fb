import java.util.*;

/**
 * Created by Larry Liu on 10/31/2017.
 * 269. Alien Dictionary
 */
public class p269 {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
        for (int i = 0; i < words.length-1; i++) {
            for (int j = 0; j < Math.min(words[i].length(), words[i+1].length()); j++) {
                char last = words[i].charAt(j);
                char curr = words[i+1].charAt(j);
                if (last != curr) {
                    map.putIfAbsent(last, new HashSet<>());
                    if (!map.get(last).contains(curr)) {
                        map.get(last).add(curr);
                        degree.put(curr, degree.get(curr) + 1);
                    }
                    break;
                }
            }
        }

        return bfs(map, degree);

    }

    private String bfs(Map<Character, Set<Character>> map, Map<Character, Integer> degree) {
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (char c: degree.keySet()) if (degree.get(c) == 0) q.add(c);
        while (!q.isEmpty()) {
            char curr = q.poll();
            sb.append(curr);
            if (map.containsKey(curr)) {
                for (char neighbor: map.get(curr)) {
                    degree.put(neighbor, degree.get(neighbor)-1);
                    if (degree.get(neighbor) == 0) q.offer(neighbor);
                }
            }
        }
        if (sb.length() != degree.size()) return "";
        return sb.toString();
    }
    private boolean topoSort(StringBuilder sb, Map<Character, Set<Character>> map, boolean[][] visited, char curr) {
        visited[0][curr] = true;
        visited[1][curr] = true;

        if (map.containsKey(curr)) {
            for (char neighbor: map.get(curr)) {
                if (!visited[0][neighbor] && topoSort(sb, map, visited, neighbor)) return true;
                else if (visited[1][neighbor]) return true;
            }
        }
        sb.insert(0, curr);
        visited[1][curr] = false;
        return false;
    }

    public static void main(String[] args) {
        p269 sol = new p269();
        System.out.println(sol.alienOrder(new String[]{"za","zb","ca","cb"}));
    }
}
