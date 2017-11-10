import java.util.*;

/**
 * Created by Larry Liu on 11/8/2017.
 * 721. Accounts Merge
 */
public class p721 {
    class Node {
        String email;
        String name;
        List<Node> neighbors;
        Node(String email, String name) {
            this.email = email;
            this.name = name;
            neighbors = new ArrayList<>();
        }

    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new LinkedList<>();
        Map<String, Node> map = buildGraph(accounts);
        Set<String> visited = new HashSet<>();
        for (String email: map.keySet()) {
            if (!visited.contains(email)) {
                visited.add(email);
                List<String> res = new LinkedList<>();
                res.add(email);
                dfs(map.get(email), visited, res);
                res.sort((a, b)->a.compareTo(b));
                res.add(0, map.get(email).name);
                result.add(res);
            }
        }
        return result;
    }

    private Map<String, Node> buildGraph(List<List<String>> accounts) {
        Map<String, Node> graph = new HashMap<>();
        for (List<String> account: accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                graph.putIfAbsent(email, new Node(email, name));
                if (i > 1) {
                    graph.get(account.get(i-1)).neighbors.add(graph.get(email));
                    graph.get(email).neighbors.add(graph.get(account.get(i-1)));
                }
            }
        }
        return graph;
    }

    private void dfs(Node root, Set<String> visited, List<String> res) {
        for (Node node: root.neighbors) {
            if (!visited.contains(node.email)) {
                visited.add(node.email);
                res.add(node.email);
                dfs(node, visited, res);
            }
        }
    }
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
    }
}
