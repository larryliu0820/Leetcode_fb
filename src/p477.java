/**
 * Created by Larry Liu on 10/29/2017.
 * 477. Total Hamming Distance
 */
public class p477 {
    public int totalHammingDistance(int[] nums) {
        int count = 0;
        int mask = 1;

        while (mask < (Integer.MAX_VALUE >> 1)) {
            int zeros = 0, ones = 0;
            boolean end = true;
            for (int num: nums) {
                if (num >= mask) end = false;
                int currBit = (num & mask)==0?0:1;
                if (currBit == 1) ones++;
                else zeros++;
            }
            if (end) break;
            mask <<= 1;
            count += zeros * ones;
        }
        return count;
    }

    public static void main(String[] args) {
        p477 sol = new p477();
        sol.totalHammingDistance(new int[]{4, 14, 2});
    }
}
