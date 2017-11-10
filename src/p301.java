import java.util.ArrayList;
import java.util.List;

/**
 * Created by Larry Liu on 10/29/2017.
 * 301. Remove Invalid Parentheses
 */
public class p301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, new char[]{'(',')'}, s, 0, 0);
        return res;
    }

    private void dfs(List<String> res, char[] pair, String s, int last_i, int last_j) {
        int counter = 0;
        for (int i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) counter++;
            else if (s.charAt(i) == pair[1]) counter--;
            if (counter >= 0) continue;
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == pair[1] && (j == last_j || s.charAt(j-1) != pair[1]))
                    dfs(res, pair, s.substring(0, j) + s.substring(j+1), i, j);
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') {
            dfs(res, new char[]{')', '('}, reversed, 0, 0);
        } else res.add(reversed);
    }
}
