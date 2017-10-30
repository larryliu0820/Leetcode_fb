import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 10/29/2017.
 * 273. Integer to English Words
 */
public class p273 {
    public String numberToWords(int num) {
        String[] belowTwenty = new String[]{"Zero", "One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] units = new String[]{"", "Thousand", "Million", "Billion"};
        List<String> res = new LinkedList<>();
        int ind = 0;
        while (num > 0) {
            List<String> list = new LinkedList<>();
            int belowThousand = num % 1000;
            int hundred = belowThousand / 100;
            int belowHundred = belowThousand % 100;
            if (hundred > 0) {
                list.add(belowTwenty[hundred]);
                list.add("Hundred");
            }
            if (belowHundred >= 20) {
                list.add(tens[belowHundred / 10]);
                if (belowHundred % 10 > 0) list.add(belowTwenty[belowHundred % 10]);
            } else if (belowHundred > 0){
                list.add(belowTwenty[belowHundred]);
            }
            num /= 1000;
            if (ind > 0 && list.size() > 0) list.add(units[ind]);
            res.addAll(0, list);
            ind++;
        }
        if (res.size() == 0) res.add(belowTwenty[0]);
        StringBuilder sb = new StringBuilder();
        for (String str: res) sb.append(" ").append(str);
        sb.delete(0,1);
        return sb.toString();
    }
}
