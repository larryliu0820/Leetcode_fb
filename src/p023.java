import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by mengwliu on 10/30/17
 * 23. Merge k Sorted Lists
 */
public class p023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt((a)->a.val));
        for (ListNode node: lists) if (node != null) pq.offer(node);
        ListNode root = pq.peek(), itr = root;

        while (!pq.isEmpty()) {
            itr = pq.poll();
            if (itr.next != null) pq.offer(itr.next);
            if (!pq.isEmpty()) itr.next = pq.peek();
        }
        return root;
    }
}
