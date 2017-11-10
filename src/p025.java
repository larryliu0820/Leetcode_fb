import java.util.Stack;

/**
 * Created by Larry Liu on 11/8/2017.
 * 25. Reverse Nodes in k-Group
 */
public class p025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode itr = dummy;
        for (int i = 0; itr != null; i++) {
            if (i % k == 0) itr.next = reverseK(itr.next, k);
            itr = itr.next;
        }
        head = dummy.next;
        dummy.next = null;
        return head;
    }

    private ListNode reverseK(ListNode head, int k) {
        if (head == null) return null;
        if (k < 2) return head;
        ListNode itr = head;
        Stack<ListNode> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            if (itr == null) return head;
            stack.push(itr);
            itr = itr.next;
        }
        ListNode nextHead = itr;
        ListNode newHead = stack.pop();
        itr = newHead;
        while (!stack.isEmpty()) {
            itr.next = stack.peek();
            itr = stack.pop();
        }
        itr.next = nextHead;
        return newHead;
    }
}
