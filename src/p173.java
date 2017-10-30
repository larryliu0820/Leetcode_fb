import java.util.Stack;

/**
 * Created by Larry Liu on 10/29/2017.
 * 173. Binary Search Tree Iterator
 */
public class p173 {
    private Stack<TreeNode> stack;
    public p173(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }

    private void pushLeft(TreeNode curr) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode next = stack.pop();
        pushLeft(next.right);
        return next.val;
    }
}
