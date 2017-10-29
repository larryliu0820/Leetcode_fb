import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Larry Liu on 10/27/2017.
 * 117. Populating Next Right Pointers in Each Node II
 */
public class p117 {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeLinkNode> level = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeLinkNode curr = queue.poll();
                curr.next = queue.isEmpty()?null:queue.peek();
                if (curr.left != null) level.offer(curr.left);
                if (curr.right != null) level.offer(curr.right);
            }
            queue = level;
        }
    }
}
