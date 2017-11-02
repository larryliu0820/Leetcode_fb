import java.util.*;

/**
 * Created by Larry Liu on 10/31/2017.
 * 218. The Skyline Problem
 */
public class p218 {
    class Edge {
        int x, h;
        boolean isUp;
        Edge(int x, int h, boolean isUp) {this.x = x; this.h = h; this.isUp = isUp;}
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<Edge> list = new LinkedList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>((Edge edge, Edge t1)-> t1.h-edge.h);
        Map<Edge, Edge> map = new HashMap<>();
        for (int[] building: buildings) {
            Edge up = new Edge(building[0], building[2], true);
            list.add(up);
            Edge down = new Edge(building[1], building[2], false);
            list.add(down);
            map.put(down, up);
        }
        list.sort((Edge edge, Edge t1)-> {
            if (edge.x == t1.x) {
                if (edge.isUp && !t1.isUp) return -1;
                else if (!edge.isUp && t1.isUp) return 1;
                else {
                    if (edge.isUp) return t1.h - edge.h;
                    else return edge.h - t1.h;
                }
            } else return edge.x - t1.x;

        });
        List<int[]> res = new LinkedList<>();
        for (Edge e: list) {
            if (e.isUp) {
                if (pq.isEmpty() || e.h > pq.peek().h) {
                    res.add(new int[]{e.x, e.h});
                }
                pq.offer(e);
            } else {
                pq.remove(map.get(e));
                if (pq.isEmpty() || pq.peek().h < e.h) {
                    int height = pq.isEmpty()?0:pq.peek().h;
                    res.add(new int[]{e.x, height});
                }
            }
        }
        return res;
    }
}
