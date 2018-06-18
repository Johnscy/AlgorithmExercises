package Algotithms_Fourth_Edition.Chapter3;
import java.util.*;

/**
 * 用多条链表来存储键值对（同一条链表表示hash值相同）
 * @param <Key>
 * @param <Value>
 */
public class SeparateChainingHashST<Key,Value> {
    private static final int INIT_CAPACITY = 4;
    private int N;  //键值对总数
    private int M;  //散列表大小
    private SequentialSearchST<Key,Value>[] st; //存放链表对象的数组，数组中每个元素都是顺序查找的链表

    public SeparateChainingHashST(){
        this(INIT_CAPACITY);
    }
    public SeparateChainingHashST(int M){
        //创建M条链表
        this.M = M;
        st = (SequentialSearchST<Key,Value>[]) new SequentialSearchST[M];   //类型转换。因为不支持泛型数组
        for (int  i = 0;i < M;i++)
            st[i] = new SequentialSearchST();
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key){
        return (Value)st[hash(key)].get(key);
    }

    public void put(Key key, Value val){
        if (N >= 10*M)  resize(2*M);
        if (!st[hash(key)].contains(key)) N++;
        st[hash(key)].put(key,val);
    }

    public void delete(Key key) {
        int i = hash(key);
        if (st[i].contains(key)) N--;
        st[i].delete(key);

        if (M > INIT_CAPACITY && N <= 2*M) resize(M/2);
    }

    private void resize(int cap){
        SeparateChainingHashST<Key,Value> temp = new SeparateChainingHashST<Key,Value>(cap);
        for (int i = 0; i < M; i++)
            for (Key key : st[i].keys())
                temp.put(key, st[i].get(key));
        this.M = temp.M;
        this.N = temp.N;
        this.st = temp.st;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<Key>();
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys())
                queue.offer(key);
        }
        return queue;
    }

    public static void main(String[] args) {

    }
}
