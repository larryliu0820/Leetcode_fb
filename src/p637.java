import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mengwliu on 10/20/17
 * 637. Average of Levels in Binary Tree
 */
public class p637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Queue<TreeNode> level = new LinkedList<>();
            double sum = 0;
            int size = q.size();
            while (!q.isEmpty()) {
                TreeNode curr = q.poll();
                sum += curr.val;
                if (curr.left != null) level.offer(curr.left);
                if (curr.right != null) level.offer(curr.right);
            }
            res.add(sum / size);
            q = level;
        }
        return res;
    }
}
