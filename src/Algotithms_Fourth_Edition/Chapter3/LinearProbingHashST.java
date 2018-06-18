package Algotithms_Fourth_Edition.Chapter3;
import java.util.*;

/**
 * 用两个数组并行，一个保存键，一个保存值。
 * @param <Key>
 * @param <Value>
 */
public class LinearProbingHashST<Key,Value> {
    private int N;          //符号表中键值对的总数
    private int M;          //线性探测表的大小（M > N）
    private Key[] keys;     //键
    private Value[] vals;   //值

    public LinearProbingHashST(int capacity){
        M = capacity;
        N = 0;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }


    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap){
        LinearProbingHashST<Key,Value> t = new LinearProbingHashST<Key,Value>(cap);
        for (int i = 0; i < M; i++)
            if (keys[i] != null)
                t.put(keys[i],vals[i]);
        keys = t.keys;
        vals = t.vals;
        M    = t.M;
    }

    public void put(Key key, Value val){
        if (N >= M/2) resize(2*M);
        int i;
        for (i = hash(key);keys[i] != null;i=(i+1) % M)
            if (keys[i].equals(key)){
                vals[i] = val;
                return;
            }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key);keys[i] != null;i = (i+1) % M)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

    public void delete(Key key){
        if (!contains(key)) return;
        int  i =hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % M;
        keys[i] = null;
        vals[i] = null;         //删除key键值对
        /////////////////////////////////////////
        i = (i + 1) % M;        //将key右侧的所有键（值对）重新插入散列表。
        while (keys[i] != null){
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo,valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M/8) resize(M/2);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<Key>();
        for (int i = 0; i < M; i++) {
            if (keys[i] != null)
                queue.offer(keys[i]);
        }
        return queue;
    }

    public static void main(String[] args) {

    }
}
