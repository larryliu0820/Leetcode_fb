import java.util.*;

/**
 * Created by mengwliu on 10/28/17
 * 554. Brick Wall
 */
public class p554 {
    class Brick {
        long s, e;
        Brick(long s, long e) {this.s = s; this.e = e;}
    }
    public int leastBricks(List<List<Integer>> wall) {
        List<List<Brick>> brickWall = new LinkedList<>();
        for (List<Integer> level: wall) {
            List<Brick> brickLevel = new LinkedList<>();
            long s = 0;
            for (int len: level) {
                Brick b = new Brick(s, s+len);
                brickLevel.add(b);
                s += len;
            }
            brickWall.add(brickLevel);
        }
        PriorityQueue<List<Brick>> pq = new PriorityQueue<>(Comparator.comparingLong((l)->l.get(0).e));
        int bricks = wall.size(), original = wall.size();
        for (List<Brick> level: brickWall) pq.offer(level);

        long minVal = pq.peek().get(0).e;
        int count = 0;
        while (!pq.isEmpty()) {
            List<Brick> level = pq.poll();
            if (level.get(0).e == minVal) {
                level.remove(0);
                count++;
                if (level.size() > 0) pq.offer(level);
            } else {
                bricks = Math.min(bricks, original-count);
                count = 0;
                pq.offer(level);
                minVal = pq.peek().get(0).e;
            }
        }
        return bricks;
    }

    public static void main(String[] args) {
        p554 sol = new p554();
        List<List<Integer>> wall = new LinkedList<>();
        Integer[] arr = new Integer[]{5, 2, 1, 1, 1};
        Integer[] arr2 = new Integer[]{9, 1};
        Integer[] arr3 = new Integer[]{9, 1};
        wall.add(Arrays.asList(arr));
        wall.add(Arrays.asList(arr2));
        wall.add(Arrays.asList(arr3));
        System.out.println(sol.leastBricks(wall));
    }
}
