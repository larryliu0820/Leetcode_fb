import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * Created by mengwliu on 10/20/17
 * 653. Two Sum IV - Input is a BST
 */
public class p653 {
    enum Direction {
        LEFT,
        RIGHT
    }
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Stack<TreeNode> forwardStack = new Stack<>();
        Stack<TreeNode> backwardStack = new Stack<>();
        pushDirection(forwardStack, Direction.LEFT, root);
        pushDirection(backwardStack, Direction.RIGHT, root);
        TreeNode forwardItr = forwardStack.pop();
        TreeNode backwardItr = backwardStack.pop();
        while (forwardItr != backwardItr) {
            if (forwardItr.val + backwardItr.val > k) {
                pushDirection(backwardStack, Direction.RIGHT, backwardItr.left);
                backwardItr = backwardStack.pop();
            } else if (forwardItr.val + backwardItr.val < k) {
                pushDirection(forwardStack, Direction.LEFT, forwardItr.right);
                forwardItr = forwardStack.pop();
            } else return true;
        }
        return false;
    }

    private void pushDirection(Stack<TreeNode> stack, Direction dir, TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = dir==Direction.LEFT?node.left:node.right;
        }
    }
}
