/**
 * Created by Larry Liu on 10/24/2017.
 * 43. Multiply Strings
 */
public class p043 {
    public String multiply(String num1, String num2) {
        if (num2.equals("0") || num1.equals("0")) return "0";
        int M = num1.length(), N = num2.length();
        int[] res = new int[M+N];
        for (int i = 0; i < res.length-1; i++) {
            for (int j = 0; j <= i; j++) {
                if (j > M - 1 || i - j > N - 1) continue;
                int n1 = num1.charAt(M-1-j) - '0';
                int n2 = num2.charAt(N-1-(i-j)) - '0';
                int temp = n1 * n2;
                res[i] += temp % 10;
                res[i+1] += temp / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < res.length-1; i++) {
            int sum = res[i] + carry;
            carry = sum / 10;
            sb.insert(0, sum % 10 );
        }
        if (res[res.length-1] + carry != 0) sb.insert(0, res[res.length-1] + carry);
        return sb.toString();
    }

    public static void main(String[] args) {
        p043 sol = new p043();
        sol.multiply("123", "456");
    }
}
