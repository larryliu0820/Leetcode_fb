/**
 * Created by Larry Liu on 10/24/2017.
 * 98. Validate Binary Search Tree
 */
public class p098 {
    class Result {
        boolean isValid;
        int max;
        int min;
        Result(boolean isValid, int max, int min) {
            this.isValid = isValid;
            this.max = max;
            this.min = min;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root).isValid;
    }

    private Result helper(TreeNode node) {
        Result res = new Result(true, node.val, node.val);
        if (node.left == null && node.right == null) {
            return new Result(true, node.val, node.val);
        }
        if (node.left != null) {
            Result leftRes = helper(node.left);
            if (!leftRes.isValid || leftRes.max >= node.val) {
                res.isValid = false;
                return res;
            } else {
                res.min = leftRes.min;
            }
        }

        if (node.right != null) {
            Result rightRes = helper(node.right);
            if (!rightRes.isValid || rightRes.min <= node.val) {
                res.isValid = false;
                return res;
            } else {
                res.max = rightRes.max;
            }
        }
        return res;
    }
}
