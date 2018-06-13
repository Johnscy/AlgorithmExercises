package Algotithms_Fourth_Edition.Chapter3;
import java.util.*;

/**
 * 使用无序数组来实现符号表
 */
public class ArrayST <Key ,Value> {
    private static final int INIT_SIZE = 8;
    private Key[] keys; //存放键的数组
    private Value[] vals;   //存放值的数组
    private int N = 0;  //数组的大小

    public ArrayST() {
        keys = (Key[]) new Object[INIT_SIZE];
        vals = (Value[]) new Object[INIT_SIZE];
    }

    private void resize(int capacity) {
        Key[]   tempk = (Key[])   new Object[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++)
            tempk[i] = keys[i];
        for (int i = 0; i < N; i++)
            tempv[i] = vals[i];
        keys = tempk;
        vals = tempv;
    }
    public void put(Key key, Value val) {
        delete(key);
        // double size of arrays if necessary
        if (N >= vals.length)  resize(2*N);
        // add new key and value at the end of array
        vals[N] = val;
        keys[N] = key;
        N++;
    }
    public Value get(Key key){
        for (int i = 0; i < N; i++)
            if (keys[i].equals(key)) return vals[i];
        return null;
    }
    public void delete(Key key){
        for (int i = 0; i < N; i++)
            if (key.equals(keys[i])) {
                keys[i] = keys[N-1];
                vals[i] = vals[N-1];
                keys[N-1] = null;
                vals[N-1] = null;
                N--;
                if (N > 0 && N == keys.length/4)
                    resize(keys.length/2);
                return;
            }
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean contains(Key key){
        return get(key) != null;
    }
    public Iterable<Key> keys(){
        Queue<Key> queue = new LinkedList<Key>();
        for (int i = 0;i < N;i++)
            queue.offer(keys[i]);
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
