package Algotithms_Fourth_Edition.Chapter2;

public class IndexMinPQ <Key extends Comparable<Key>>{
    private int N;          //PQ中的元素数量
    private int[] pq;       //索引二叉堆，由1开始
    private int[] qp;       //逆序：qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys;     //有优先级之分的元素

    public IndexMinPQ(int maxN){        //构造函数
        keys = (Key[]) new Comparable[maxN+1];
        pq   = new int[maxN+1];
        qp   = new int[maxN+1];
        for (int i = 0;i <= maxN;i++)
            qp[i] = -1;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public boolean contains(int k){
        return qp[k] != -1;
    }

    public void insert(int k, Key key){
        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;
        swim(N);
    }

    public Key min(){
        return keys[pq[1]];
    }

    public int delMin(){
        int indexOfMin = pq[1];
        exch(1,N--);
        sink(1);
        keys[pq[N+1]] = null;
        qp[pq[N+1]] = -1;
        return indexOfMin;
    }

    public int minIndex(){
        return pq[1];
    }

    public void change(int k,Key key){
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public void delete(int k){

    }

    private boolean less(int i, int j){
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void exch(int i, int j){
        Key t = keys[pq[i]];
        keys[pq[i]] = keys[pq[j]];
        keys[pq[j]] = t;
        qp[i] = ;
        qp[j] = ;
    }

    private void swim(int k){
        while(k > 1 && less(k/2,k)){
            exch(k/2,k);
            k = k/2;
        }
    }

    private void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            if (j < N && less(j,j+1)) j++;
            if(! less(k,j)) break;
            exch(k,j);
            k = j;
        }
    }

    public static void main(String[] args){

    }

}
