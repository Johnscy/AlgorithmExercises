package LeetCode;
import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */

public class LRUCache_146 {
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    class LRUCache {
        //Hashtable + Double linked list
        //双向链表中最近使用的在右侧，使用频率低的在左侧
        //要继续提高效率，可以自己写类来存储对应的<key,DLNode>
        class DLNode{
            int key;
            int value;
            DLNode prev; //指向前一个结点
            DLNode next; //指向后一个结点
            DLNode(int k, int v){
                key = k;
                value = v;
            }
            DLNode(){
                this(0,0);
            }
        }
        class DoubleLinkedList{
            DLNode head;   //dummy node，实际并不存在。
            int size;
            DoubleLinkedList(){
                head = new DLNode();
                head.next = head;
                head.prev = head;
                size = 0;
            }
            DLNode addLast(DLNode newNode){
                DLNode last = head.prev;
                last.next = newNode;
                newNode.prev = last;
                newNode.next = head;
                head.prev = newNode;
                size++;
                return newNode;
            }
            void remove(DLNode node){
                DLNode prevNode = node.prev;
                DLNode nextNode = node.next;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
                size--;
            }
        }
        private int CAPACITY;
        private HashMap<Integer,DLNode> map;
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
            DLNode newNode = cache.addLast(new DLNode(key,value));
            map.put(key,newNode);
            return value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)){
                DLNode node = map.get(key);
                cache.remove(node);
            }else if (cache.size == CAPACITY){
                DLNode eliminated = cache.head.next;
                map.remove(eliminated.key);
                cache.remove(eliminated);
            }
            DLNode newNode = cache.addLast(new DLNode(key,value));
            map.put(key,newNode);
        }
    }
}
