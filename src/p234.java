/**
 * Created by mengwliu on 10/20/17
 * 234. Palindrome Linked List
 */
public class p234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reversedHead = reverse(slow);
        while (head != null && reversedHead != null) {
            if (head.val != reversedHead.val) return false;
            head = head.next;
            reversedHead = reversedHead.next;
        }
        return true;

    }

    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode next = node.next;
        ListNode head = reverse(node.next);
        node.next = null;
        next.next = node;
        return head;
    }
}
