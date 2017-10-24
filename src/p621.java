import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Larry Liu on 10/24/2017.
 * 621. Task Scheduler
 */
public class p621 {
    public int leastInterval(char[] tasks, int n) {
        int[] memo = new int[26];
        for (char c: tasks) memo[c-'A']++;
        Arrays.sort(memo);
        int num = 1;
        for (int i = 0; i < 25; i++) if (memo[i] == memo[25]) num++;
        return Math.max(tasks.length, (memo[25] - 1) * (n+1) + num);
    }
}
