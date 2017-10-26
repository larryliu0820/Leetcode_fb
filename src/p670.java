/**
 * Created by Larry Liu on 10/26/2017.
 * 670. Maximum Swap
 */
public class p670 {
    public int maximumSwap(int num) {
        if (num < 10) return num;
        String s = Integer.toString(num);
        int[] largest = new int[s.length()];
        largest[s.length()-1] = s.length()-1;
        for (int i = s.length()-2; i >= 0; i--) {
            if (s.charAt(i) - '0' >= s.charAt(largest[i+1]) - '0') largest[i] = i;
            else largest[i] = largest[i+1];
        }
        for (int i = 0; i < largest.length; i++) {
            if (largest[i] != i && s.charAt(i) != s.charAt(largest[i])) {
                return helper(s, i, largest[i]);
            }
        }
        return num;
    }

    private int helper(String s, int i, int j) {
        char ci = s.charAt(i);
        char cj = s.charAt(j);
        char[] arr = s.toCharArray();
        arr[i] = cj;
        arr[j] = ci;
        return Integer.parseInt(String.valueOf(arr));
    }
}
