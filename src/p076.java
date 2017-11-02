/**
 * Created by Larry Liu on 11/1/2017.
 * 76. Minimum Window Substring
 */
public class p076 {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c: t.toCharArray()) map[c]++;
        int counter = t.length(), begin = 0, end = 0, maxLen = Integer.MAX_VALUE;
        String res = "";
        while (end < s.length()) {
            if (map[s.charAt(end)] > 0) {
                counter--;
            }
            map[s.charAt(end)]--;
            end++;
            while (counter == 0) {
                if (end - begin < maxLen) {
                    maxLen = end - begin;
                    res = s.substring(begin, end);
                }
                if (map[s.charAt(begin)] == 0) {
                    counter++;
                }
                map[s.charAt(begin)]++;
                begin++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        p076 sol = new p076();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
    }
}
