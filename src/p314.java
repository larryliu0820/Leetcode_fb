import java.util.*;

/**
 * Created by Larry Liu on 10/24/2017.
 * 314. Binary Tree Vertical Order Traversal
 */
public class p314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<TreeNode, Integer> nodeIntegerMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        nodeIntegerMap.put(root, 0);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            int num = nodeIntegerMap.get(curr);
            map.putIfAbsent(num, new ArrayList<>());
            map.get(num).add(curr.val);
            if (curr.left != null) {
                nodeIntegerMap.put(curr.left, num-1);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                nodeIntegerMap.put(curr.right, num+1);
                q.offer(curr.right);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.keySet());
        while (!pq.isEmpty()) res.add(map.get(pq.poll()));
        return res;
    }
}
