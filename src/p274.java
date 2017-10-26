import java.util.Arrays;

/**
 * Created by Larry Liu on 10/26/2017.
 * 274. H-Index
 */
public class p274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int j = citations.length - 1; j >= 0; j--) {
            int i = citations.length - j;
            if (i == citations[j]) return i;
            else if (i > citations[j]) return i-1;
        }
        return citations.length;
    }
}
