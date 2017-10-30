import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Larry Liu on 10/29/2017.
 * 297. Serialize and Deserialize Binary Tree
 */
public class p297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        sb.append(root.val);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.left != null) {
                queue.offer(curr.left);
                sb.append(",").append(curr.left.val);
            } else {
                sb.append(",").append("#");
            }

            if (curr.right != null) {
                queue.offer(curr.right);
                sb.append(",").append(curr.right.val);
            } else {
                sb.append(",").append("#");
            }
        }
        while (sb.charAt(sb.length()-1) == '#') sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("#")) return null;
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (i < nodes.length && !nodes[i].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.left);
            }
            i++;
            if (i < nodes.length && !nodes[i].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }
}
