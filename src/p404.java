/**
 * Created by mengwliu on 10/22/17
 * 404. Sum of Left Leaves
 */
public class p404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return helper(root);
    }

    private int helper(TreeNode node) {
        int res = 0;
        if (node.left != null && node.left.left == null && node.left.right == null)
            res += node.left.val;
        else if (node.left != null) res += helper(node.left);

        if (node.right != null) res += helper(node.right);

        return res;

    }
}
