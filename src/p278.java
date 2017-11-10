/**
 * Created by mengwliu on 10/20/17
 * 278. First Bad Version
 */
public class p278 {
    boolean isBadVersion(int version) {
        return version == 5;
    }
    public int firstBadVersion(int n) {
        if (n == 1) return 1;
        int lo = 1, hi = n, mid;
        while (lo <= hi) {
            mid = lo / 2 + hi / 2 + (lo % 2 + hi % 2) / 2;
            if (isBadVersion(mid)) hi = mid-1;
            else lo = mid+1;
        }
        return lo;
    }
}
