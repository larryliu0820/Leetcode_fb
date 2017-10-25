import java.util.*;

/**
 * Created by Larry Liu on 10/24/2017.
 * 314. Binary Tree Vertical Order Traversal
 */
public class p314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<TreeNode, Integer> nodeIntegerMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        nodeIntegerMap.put(root, 0);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int count = nodeIntegerMap.get(curr);
            map.putIfAbsent(count, new LinkedList<>());
            map.get(count).add(curr.val);
            if (curr.left != null) {
                nodeIntegerMap.put(curr.left, count-1);
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                nodeIntegerMap.put(curr.right, count+1);
                queue.offer(curr.right);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.keySet());
        while (!pq.isEmpty()) {
            res.add(map.get(pq.poll()));
        }
        return res;
    }
}
