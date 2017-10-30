/**
 * Created by Larry Liu on 10/29/2017.
 * 275. H-Index II
 */
public class p275 {
    public int hIndex(int[] citations) {
        for (int j = citations.length - 1; j >= 0; j--) {
            int i = citations.length - j;
            if (i == citations[j]) return i;
            else if (i > citations[j]) return i-1;
        }
        return citations.length;
    }
}
