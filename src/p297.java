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
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        sb.append(root.val);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                q.offer(curr.left);
                sb.append(',').append(curr.left.val);
            } else sb.append(',').append("#");

            if (curr.right != null) {
                q.offer(curr.right);
                sb.append(',').append(curr.right.val);
            } else sb.append(',').append("#");
        }
        while (sb.charAt(sb.length()-1) == '#') sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("#")) return null;
        String[] arr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        int i = 1;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (i < arr.length && !arr[i].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.left);
            }
            i++;
            if (i < arr.length && !arr[i].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }
}
