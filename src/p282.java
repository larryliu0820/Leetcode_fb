import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 10/30/17
 * 282. Expression Add Operators
 */
public class p282 {
    List<String> res;
    String num;
    int target;
    public List<String> addOperators(String num, int target) {
        res = new LinkedList<>();
        this.num = num;
        this.target = target;
        dfs("", 0, 0, 0);
        return res;
    }

    private void dfs(String path, long result, long last, int index) {
        if (index == num.length()) {
            if (result == target) res.add(path);
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') break;
            long curr = Long.parseLong(num.substring(index, i+1));
            if (index == 0) {
                dfs(path+curr, curr, curr, i + 1);
            } else {
                dfs(path + "+" + curr, result + curr, curr, i + 1);
                dfs(path + "*" + curr, (result - last) + last * curr, last * curr, i + 1);
                dfs(path + "-" + curr, result - curr, -curr, i + 1);
            }
        }
    }
}
