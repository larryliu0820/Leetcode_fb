/**
 * Created by Larry Liu on 10/23/2017.
 * 161. One Edit Distance
 */
public class p161 {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i+1).equals(t.substring(i+1));
                } else if (s.length() < t.length()) {
                    return s.substring(i).equals(t.substring(i+1));
                } else {
                    return s.substring(i+1).equals(t.substring(i));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }

}
