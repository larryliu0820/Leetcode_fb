import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 10/25/17.
 * 17. Letter Combinations of a Phone Number
 */
public class p017 {
    public List<String> letterCombinations(String digits) {
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new LinkedList<>();
        for (char c: digits.toCharArray()) {
            List<String> temp = new LinkedList<>();
            String letters = map[c-'0'];
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i+1);
                if (res.size() == 0) {
                    temp.add(letter);
                } else {
                    for (String s: res) temp.add(s+letter);
                }
            }
            res = temp;
        }
        return res;
    }
}
