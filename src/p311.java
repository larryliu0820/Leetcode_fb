import java.util.HashMap;
import java.util.Map;

/**
 * Created by Larry Liu on 10/26/2017.
 * 311. Sparse Matrix Multiplication
 */
public class p311 {
    public int[][] multiply(int[][] A, int[][] B) {
        Map<Integer, Map<Integer, Integer>> mapA = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> mapB = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            Map<Integer, Integer> row = new HashMap<>();
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) row.put(j, A[i][j]);
            }
            if (!row.isEmpty()) mapA.put(i, row);
        }

        for (int j = 0; j < B[0].length; j++) {
            Map<Integer, Integer> col = new HashMap<>();
            for (int i = 0; i < B.length; i++) {
                if (B[i][j] != 0) col.put(i, B[i][j]);
            }
            if (!col.isEmpty()) mapB.put(j, col);
        }

        int[][] res = new int[A.length][B[0].length];
        for (int i = 0; i < res.length; i++) {
            if (!mapA.containsKey(i)) continue;
            Map<Integer, Integer> row = mapA.get(i);
            for (int j = 0; j < res[0].length; j++) {
                if (!mapB.containsKey(j)) continue;
                Map<Integer, Integer> col = mapB.get(j);
                for (int key: row.keySet()) {
                    if (!col.containsKey(key)) continue;
                    res[i][j] += row.get(key) * col.get(key);
                }
            }
        }
        return res;
    }
}
