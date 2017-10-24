import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 10/20/17
 */
public class p257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) return res;
        helper(res, "", root);
        return res;
    }

    private void helper(List<String> res, String path, TreeNode node) {
        String pathNext = path;
        if (path.length() != 0) pathNext += "->";
        pathNext += node.val;
        if (node.left == null && node.right == null) {
            res.add(pathNext);
            return;
        }
        if (node.left != null) helper(res, pathNext, node.left);
        if (node.right != null) helper(res, pathNext, node.right);
    }
}
