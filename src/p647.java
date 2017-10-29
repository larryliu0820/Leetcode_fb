/**
 * Created by Larry Liu on 10/28/2017.
 * 647. Palindromic Substrings
 */
public class p647 {
    int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return count;
        for (int i = 0; i < s.length(); i++) {
            extendCount(s, i, i);
            extendCount(s, i, i+1);
        }
        return count;
    }
    private void extendCount(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
