/**
 * Created by mengwliu on 10/22/17
 * 543. Diameter of Binary Tree
 */
public class p543 {
    int maxLen = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return maxLen;

    }

    private int helper(TreeNode node) {
        if (node.left == null && node.right == null) return 0;

        int leftLen = node.left == null? 0 : helper(node.left) + 1;
        int rightLen = node.right == null? 0 : helper(node.right) + 1;
        maxLen = Math.max(maxLen, leftLen + rightLen);
        return Math.max(leftLen, rightLen);
    }
}
