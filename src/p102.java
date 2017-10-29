import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Larry Liu on 10/27/2017.
 * 102. Binary Tree Level Order Traversal
 */
public class p102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> level = new LinkedList<>();
            List<Integer> levelVals = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                levelVals.add(curr.val);
                if (curr.left != null) level.offer(curr.left);
                if (curr.right != null) level.offer(curr.right);
            }
            res.add(levelVals);
            queue = level;
        }
        return res;
    }
}
