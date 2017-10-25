import java.util.List;
import java.util.Stack;

/**
 * Created by Larry Liu on 10/25/2017.
 * 636. Exclusive Time of Functions
 */
public class p636 {
    class Function {
        int id;
        int time;
        boolean isStart;
        public Function(int id, int time, boolean start) {
            this.id = id;
            this.time = time;
            this.isStart = start;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] time = new int[n];
        Stack<Function> stack = new Stack<>();
        for (String log: logs) {
            int currId = Integer.parseInt(log.split(":")[0]);
            boolean isStart = log.split(":")[1].equals("start");
            int currTime = Integer.parseInt(log.split(":")[2]);
            if (stack.isEmpty()) {
                stack.push(new Function(currId, currTime, isStart));
            } else if (stack.peek().id != currId || !stack.peek().isStart || isStart) {
                time[stack.peek().id] += currTime - stack.peek().time;
                stack.push(new Function(currId, currTime, isStart));
            } else {
                Function last = stack.pop();
                time[currId] += currTime - last.time + 1;
                if (!stack.isEmpty()) {
                    stack.peek().time = currTime + 1;
                }
            }
        }
        return time;
    }
}
