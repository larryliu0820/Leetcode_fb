/**
 * Created by mengwliu on 10/22/17
 * 461. Hamming Distance
 */
public class p461 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor > 0) {
            count ++;
            xor &= (xor-1);
        }
        return count;
    }
}
