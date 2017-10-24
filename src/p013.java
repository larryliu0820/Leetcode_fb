/**
 * Created by mengwliu on 10/22/17
 * 13. Roman to Integer
 */
public class p013 {
    public int romanToInt(String s) {
        String numeralStr = "IVXLCDM";
        int[] units = new int[]{1, 5, 10, 50, 100, 500, 1000};
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            char unit = s.charAt(i);
            int index = numeralStr.indexOf(unit);
            if (index < 6 && index % 2 == 0
                    && i+1 < s.length()
                    && numeralStr.indexOf(s.charAt(i+1)) - index <= 2
                    && numeralStr.indexOf(s.charAt(i+1)) - index > 0)
                value -= units[index];
            else
                value += units[index];
        }
        return value;
    }
}
