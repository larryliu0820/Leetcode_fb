import java.util.Stack;

/**
 * Created by mengwliu on 10/27/17.
 * 71. Simplify Path
 */
public class p071 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < path.length()) {
            int index = path.indexOf('/', i+1);
            if (index == -1) {
                index = path.length();
            }
            String curr = path.substring(i+1, index);
            if (curr.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!curr.equals(".") && !curr.equals("")) {
                stack.push(curr);
            }
            i = index;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.insert(0, stack.pop()).insert(0, "/");
        if (sb.length() == 0) sb.append("/");
        return sb.toString();
    }

    public static void main(String[] args) {
        p071 sol = new p071();
        System.out.println(sol.simplifyPath("//.."));
    }
}
