import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mengwliu on 10/30/17
 * 85. Maximal Rectangle
 */
public class p085 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int M = matrix.length, N = matrix[0].length;
        int[] sum = new int[N];
        int max = 0;
        for (int i = 0; i < M; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j <= N; j++) {
                if (j < N) {
                    if (matrix[i][j] == '1') sum[j] += 1;
                    else sum[j] = 0;
                }
                while (!stack.isEmpty() && sum[stack.peek()] > sum[j]) {
                    int top = stack.pop();
                    int area = (stack.isEmpty()?j:j-stack.peek()-1) * sum[top];
                    max = Math.max(max, area);
                }
                stack.push(j);
            }

        }
        return max;
    }
}
