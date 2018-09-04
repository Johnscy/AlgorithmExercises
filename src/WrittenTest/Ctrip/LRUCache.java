package WrittenTest.Ctrip;
import java.util.*;

public class LRUCache {
    class DLNode {
        int key;
        int value;
        DLNode prev; //指向前一个结点
        DLNode next; //指向后一个结点

        DLNode(int k, int v) {
            key = k;
            value = v;
        }

        DLNode() {
            this(0, 0);
        }
    }

    class DoubleLinkedList {
        DLNode head;   //dummy node，实际并不存在。
        int size;

        DoubleLinkedList() {
            head = new DLNode();
            head.next = head;
            head.prev = head;
            size = 0;
        }

        DLNode addLast(DLNode newNode) {
            DLNode last = head.prev;
            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
            size++;
            return newNode;
        }

        void remove(DLNode node) {
            DLNode prevNode = node.prev;
            DLNode nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
    }

    private int CAPACITY;
    private HashMap<Integer, DLNode> map;
    private DoubleLinkedList cache;

    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        map = new HashMap<>();
        cache = new DoubleLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DLNode oldNode = map.get(key);
        int value = oldNode.value;
        cache.remove(oldNode);
        DLNode newNode = cache.addLast(new DLNode(key, value));
        map.put(key, newNode);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLNode node = map.get(key);
            node.value = value;
            return;
            //cache.remove(node);
        } else if (cache.size == CAPACITY) {
            DLNode eliminated = cache.head.next;
            map.remove(eliminated.key);
            cache.remove(eliminated);
        }
        DLNode newNode = cache.addLast(new DLNode(key, value));
        map.put(key, newNode);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//in.nextLine();
        LRUCache lruCache = new LRUCache(n);
        while (in.hasNextLine()) {
            String[] str = in.nextLine().split(" ");
            if (str.length == 3)
                lruCache.put(Integer.valueOf(str[1]), Integer.valueOf(str[2]));
            else if (str.length == 2)
                System.out.println(lruCache.get(Integer.valueOf(str[1])));
        }
    }
}
