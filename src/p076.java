/**
 * Created by Larry Liu on 11/1/2017.
 * 76. Minimum Window Substring
 */
public class p076 {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c: t.toCharArray()) map[c]++;
        int count = t.length();
        int tail = 0, head = 0, minLen = Integer.MAX_VALUE;
        String res = "";
        while (head < s.length()) {
            char curr = s.charAt(head++);
            if (map[curr]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (head - tail < minLen) {
                    minLen = head - tail;
                    res = s.substring(tail, head);
                }
                if (map[s.charAt(tail)] == 0) count++;
                map[s.charAt(tail)]++;
                tail++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        p076 sol = new p076();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
    }
}
