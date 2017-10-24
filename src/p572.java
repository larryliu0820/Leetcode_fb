/**
 * Created by mengwliu on 10/22/17
 * 572. Subtree of Another Tree
 */
public class p572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSubtreeHelper(s, t);
    }

    private boolean isSubtreeHelper(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        return isSubtreeHelper(s.left, t.left) && isSubtreeHelper(s.right, t.right) && s.val == t.val;
    }
}
