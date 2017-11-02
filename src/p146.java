import java.util.HashMap;
import java.util.Map;

/**
 * Created by Larry Liu on 10/31/2017.
 */
public class p146 {
    class DoublyNode {
        DoublyNode prev, next;
        int key;
        int val;
        DoublyNode(int key, int val) {this.key = key; this.val = val;}
    }
    Map<Integer, DoublyNode> map;
    DoublyNode dummyHead, dummyTail;
    int capacity;
    int size;
    public p146(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();
        dummyHead = new DoublyNode(0, 0);
        dummyTail = new DoublyNode(0, 0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DoublyNode valueNode = map.get(key);
        int res = valueNode.val;
        delete(valueNode);
        insertHead(valueNode);
        return res;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoublyNode oldNode = map.get(key);
            oldNode.val = value;
            insertHead(delete(oldNode));
        } else {
            map.put(key, new DoublyNode(key, value));
            insertHead(map.get(key));
        }
        if (size > capacity) {
            map.remove(dummyTail.prev.key);
            delete(dummyTail.prev);
        }
    }

    private void insertHead(DoublyNode node) {
        DoublyNode next = dummyHead.next;
        dummyHead.next = node;
        node.next = next;
        next.prev = node;
        node.prev = dummyHead;
        size++;
    }

    private DoublyNode delete(DoublyNode node) {
        DoublyNode prev = node.prev;
        DoublyNode next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = null;
        node.prev = null;
        size--;
        return node;
    }
}
