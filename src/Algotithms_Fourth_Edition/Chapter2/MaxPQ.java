package Algotithms_Fourth_Edition.Chapter2;

/**
 * 基于堆的优先队列
 * @param <Key>
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;
    //辅助方法
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    private void swim(int k){
        while(k >1 && less(k/2,k)){
            exch(k/2,k);
            k = k/2;
        }
    }
    private void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            if (j < N && less(j,j+1)) j++;
            if (!less(k,j)) break;
            exch(k,j);
            k = j;
        }
    }
    //主要方法
    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN+1];   //pq[0]不用，元素存在pq[1...N]中
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }
    public Key delMax(){
        Key max = pq[1];
        exch(1,N);
        N--;
        sink(1);
        return max;
    }

    public static void main(String[] args){

    }
}
