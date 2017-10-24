import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by mengwliu on 10/22/17
 * 20. Valid Parentheses
 */
public class p020 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (map.values().contains(c)) {
                stack.push(c);
            } else if (map.keySet().contains(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
