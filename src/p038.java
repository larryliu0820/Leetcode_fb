import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mengwliu on 10/22/17
 * 38. Count and Say
 */
public class p038 {
    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            int count = 1;
            for (int j = 1; j <= res.length(); j++) {
                if (j < res.length() && res.charAt(j) == res.charAt(j-1)) count++;
                else {
                    temp.append(count).append(res.charAt(j-1));
                    count = 1;
                }
            }
            res = temp;
        }
        return res.toString();
    }
}
