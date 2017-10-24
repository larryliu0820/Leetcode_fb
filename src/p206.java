/**
 * Created by mengwliu on 10/22/17
 * 206. Reverse Linked List
 */
public class p206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        ListNode newHead = reverseList(head.next);
        next.next = head;
        head.next = null;
        return newHead;

    }
}
