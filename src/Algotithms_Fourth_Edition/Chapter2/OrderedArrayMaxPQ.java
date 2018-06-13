package Algotithms_Fourth_Edition.Chapter2;

public class OrderedArrayMaxPQ <Key extends Comparable<Key>>{
    private Key[] pq;
    private int N;      //elements of PQ
    public OrderedArrayMaxPQ(int capacity){
        pq = (Key[]) new Comparable[capacity];
        N = 0;
    }

    public void insert(Key key){
        int i = N - 1;
        while(i > 0 && less(key,pq[i])){
            pq[i+1] = pq[i];
            i--;
        }
        pq[i+1] = key;
        N++;
    }

    public Key delMax(){
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
    public static void main(String[] args){
        OrderedArrayMaxPQ OAPQ = new OrderedArrayMaxPQ(10);
        OAPQ.insert("hahahahah");
        OAPQ.insert("xixixixxixiix");
        OAPQ.insert("hohohoho");
        while(!OAPQ.isEmpty()){
            System.out.print(OAPQ.delMax());
        }
        System.out.println();
    }
}
