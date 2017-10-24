/**
 * Created by mengwliu on 10/20/17
 * 28. Implement strStr()
 */
public class p028 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.equals("")) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && helper(haystack, needle, i)) return i;
        }
        return -1;
    }

    private boolean helper(String haystack, String needle, int startInd) {
        for (int i = 0; i < needle.length(); i++) {
            if (haystack.charAt(startInd+i) != needle.charAt(i)) return false;
        }
        return true;
    }
}
