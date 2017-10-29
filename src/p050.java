import java.util.HashMap;
import java.util.Map;

/**
 * Created by Larry Liu on 10/28/2017.
 * 50. Pow(x, n)
 */
public class p050 {
    public double myPow(double x, int n) {
        return helper(x, n, new HashMap<>());
    }

    public double helper(double x, int n, Map<Integer, Double> map) {
        if (!map.containsKey(n)) {
            if (n == 0) map.put(0, 1.0);
            else if (n == 1) map.put(1, x);
            else if (n == -1) map.put(-1, 1 / x);
            else {
                double half = helper(x, n / 2, map);
                double rest = helper(x, n - (n / 2 + n / 2), map);
                if (n % 2 == 0) map.put(n, half * half);
                else map.put(n, half * half * rest);
            }
        }
        return map.get(n);
    }
}
