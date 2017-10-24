/**
 * Created by mengwliu on 10/20/17
 * 168. Excel Sheet Column Title
 */
public class p168 {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            char curr = (char) ('A' + (n-1) % 26);
            res.insert(0, curr);
            n = (n - 1) / 26;
        }
        return res.toString();
    }
}
