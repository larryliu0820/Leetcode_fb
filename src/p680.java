/**
 * Created by mengwliu on 10/22/17
 * 680. Valid Palindrome II
 */
public class p680 {
    public boolean validPalindrome(String s) {
        if (s.length() < 3) return true;
        return helper(s, false);
    }

    private boolean helper(String s, boolean jumped) {
        int lo = 0, hi = s.length()-1;
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                if (jumped) return false;
                else {
                    return helper(s.substring(lo, hi), true) ||
                            helper(s.substring(lo+1, hi+1), true);
                }
            } else {
                lo++;
                hi--;
            }
        }
        return true;
    }
}
