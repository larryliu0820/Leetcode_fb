import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 10/25/17.
 * 17. Letter Combinations of a Phone Number
 */
public class p017 {
    public List<String> letterCombinations(String digits) {
        String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new LinkedList<>();
        for (char c: digits.toCharArray()) {
            String lets = letters[c-'0'];
            List<String> temp = new LinkedList<>();
            for (char l: lets.toCharArray()) {
                if (res.isEmpty()) temp.add("" + l);
                else {
                    for (String s : res) temp.add(s + l);
                }
            }
            res = temp;
        }
        return res;
    }
}
