/**
 * Created by Larry Liu on 10/27/2017.
 * 277. Find the Celebrity
 */
public class p277 {
    boolean knows(int a, int b) {
        return (a == 0 && b == 1);
    }
    public int findCelebrity(int n) {
        int[][] degree = new int[2][n];
        boolean hasRes = false;
        int candidate = helper(degree, 0);
        for (int i = 0; i < n; i++) if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        return candidate;
    }

    private int helper(int[][] deg, int curr) {
        for (int i = 0; i < deg.length; i++) {
            if (i == curr) continue;
            if (knows(curr, i)) {
                deg[0][curr]++;
                deg[1][i]++;
                if (deg[0][i] == 0) return helper(deg, i);
            }
        }
        return deg[1][curr] == deg.length-1 && deg[0][curr] == 0? -1: curr;
    }

    public int findCelebrity2(int n) {
        int x = 0;
        for (int i = 0; i < n; ++i) if (knows(x, i)) x = i;
        for (int i = 0; i < n; ++i) if (x != i && (knows(x, i) || !knows(i, x))) return -1;
        return x;
    }
}
