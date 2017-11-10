import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Larry Liu on 10/24/2017.
 * 621. Task Scheduler
 */
public class p621 {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task: tasks) freq[task-'A']++;
        Arrays.sort(freq);
        int num = 0;
        for (int i = 0; i < 26; i++) if (freq[i] == freq[25]) num++;
        return Math.max(tasks.length, (freq[25]-1) * (n+1) + num);
    }
}
