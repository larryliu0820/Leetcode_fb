/**
 * Created by mengwliu on 10/20/17
 * 67. Add Binary
 */
public class p067 {
    public String addBinary(String a, String b) {
        StringBuilder shorter = new StringBuilder(a.length() > b.length()? b: a);
        String longer = a.length()>b.length()?a:b;
        while (shorter.length() < Math.max(a.length(), b.length())) {
            shorter.insert(0, '0');
        }
        String strA = shorter.toString();

        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = strA.length()-1; i >= 0; i--) {
            carry = addBinaryHelper(strA.charAt(i), longer.charAt(i), carry, res);
        }
        if (carry > 0) res.insert(0, carry);
        return res.toString();
    }

    private int addBinaryHelper(char a, char b, int carry, StringBuilder res) {
        int valA = a - '0';
        int valB = b - '0';
        int newCarry = (valA + valB + carry) / 2;
        res.insert(0, (valA + valB + carry) % 2);
        return newCarry;
    }
}
