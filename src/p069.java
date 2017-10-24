/**
 * Created by mengwliu on 10/22/17
 * 69. Sqrt(x)
 */
public class p069 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int lo = 1, hi = x / 2;
        while (lo <= hi) {
            int mid = lo / 2 + hi / 2 + (lo % 2 + hi % 2) / 2;
            int quotient = x / mid;
            if (quotient > mid) lo = mid + 1;
            else if (quotient < mid) hi = mid - 1;
            else return mid;
        }
        return hi;
    }
}
