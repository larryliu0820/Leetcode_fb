/**
 * Created by mengwliu on 10/22/17
 * 125. Valid Palindrome
 */
public class p125 {
    public boolean isPalindrome(String s) {
        if (s.length() < 2) return true;
        char[] sc = s.toCharArray();
        int lo = 0, hi = s.length()-1;
        while (lo < hi) {
            while (lo < hi && !Character.isAlphabetic(sc[lo]) && !Character.isDigit(sc[lo])) lo++;
            while (lo < hi && !Character.isAlphabetic(sc[hi]) && !Character.isDigit(sc[hi])) hi--;
            if (lo > hi) return false;
            if (Character.toLowerCase(sc[lo]) != Character.toLowerCase(sc[hi])) return false;
            else {
                lo++;
                hi--;
            }
        }
        return true;
    }
}
