package Algotithms_Fourth_Edition.Chapter2;

public class UnorderedArrayMaxPQ <Key extends Comparable<Key>>{
    private Key[] pq;
    private int N;  //elements of PQ
    public UnorderedArrayMaxPQ(int capacity){
        pq = (Key[]) new Comparable[capacity];
        N = 0;
    }

    public void insert(Key key){
        pq[N++] = key;
    }

    public Key delMax(){
        int max = 0;
        for (int i = 0;i < N;i++){
            if(less(pq[max],pq[i])) max = i;
        }
        exch(max,N-1);
        return pq[--N];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    private boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }


    public static void main(String[] args){
        UnorderedArrayMaxPQ UAPQ = new UnorderedArrayMaxPQ(10);
        UAPQ.insert("hahahahah");
        UAPQ.insert("xixixixxixiix");
        UAPQ.insert("hohohoho");
        while(!UAPQ.isEmpty()){
            System.out.print(UAPQ.delMax());
        }
        System.out.println();
    }

}
