package Algotithms_Fourth_Edition.Chapter3;
import java.util.*;

/**
 * 顺序查找，基于无序链表
 */
public class SequentialSearchST<Key,Value> {
    private class Node{     //链表结点定义
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    private Node first;     //链表首结点
    private int N = 0;          //链表结点数

    public Value get(Key key){      //查找给定的键，返回相关联的值
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (Node x = first;x != null;x = x.next){
            if (key.equals(x.key))
                return x.val;       //命中
        }
        return null;            //未命中
    }
    public void put(Key key, Value val) {    //查找给定的键，找到则更新其值，否则在表中新建结点
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        for (Node x = first;x != null;x = x.next)
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }               //命中，更新
        first = new Node(key, val, first);      //未命中，新建结点
        N++;
    }
    public void delete(Key key){
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        first = delete(first, key);
    }
    private Node delete(Node x,Key key){
        if (x == null) return null;
        if (key.equals(x.key)){N--;return x.next;}
        x.next = delete(x.next,key);    //递归查询每个结点
        return x;       //返回头结点
    }
    public boolean contains(Key key){
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public int size(){
        return N;
    }
    public Iterable<Key> keys(){
        Queue<Key> queue = new LinkedList<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.offer(x.key);
        return queue;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        for (int i = 0;sc.hasNext();i++) {
            String key = sc.next();     //ctrl+D结束输入
            st.put(key, i);
        }
        for (String s : st.keys())
            System.out.println(s + " " + st.get(s));
    }
}