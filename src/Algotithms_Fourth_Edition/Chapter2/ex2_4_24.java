package Algotithms_Fourth_Edition.Chapter2;
import java.util.*;

/**
 * 用链表结构代替数组，来实现堆有序的优先队列
 */
public class ex2_4_24 <Item extends Comparable<Item>>{
    private class BTreeNode{      //结点
        Item item;
        BTreeNode father;
        BTreeNode lchild;
        BTreeNode rchild;
    }
    private BTreeNode first;
    private BTreeNode last;
    private int N = 0;     //优先队列中的元素个数

    private boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private void exch(BTreeNode v, BTreeNode w){   //邪术2333：只交换值，不交换结点（太麻烦）
        BTreeNode u = new BTreeNode();
        u.item = v.item;
        v.item = w.item;
        w.item = u.item;
    }
    private void swim(BTreeNode node){
        while(node!=first && less(node.father.item,node.item)){
            exch(node,node.father);
            node = node.father;
        }
    }
    private void sink(BTreeNode node){
        while(node.lchild != null){
            if(less(node.item,node.lchild.item)) {
                if (node.rchild == null)
                    exch(node.lchild, node);
                else if(less(node.lchild.item,node.rchild.item))
                    exch(node,node.rchild);
                else
                    exch(node,node.lchild);
            } else if(node.rchild != null){
                if(less(node.item,node.rchild.item))
                    exch(node,node.rchild);
                else
                    break;
            }
            else
                break;
        }
    }

    public ex2_4_24(Item item){
        first = new BTreeNode();
        first.item = item;
        first.lchild = null;
        first.rchild = null;
        first.father = first;
        last = first;
        N = 1;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void insert(Item item){  //bullshit233
        BTreeNode node = new BTreeNode();
        node.item = item;
        if(last.father.lchild == null){
            node.father = last.father;
            last.father.lchild = node;
        }
        else if(last.father.rchild == null) {
            node.father = last.father;
            last.father.rchild = node;
        }
        else{
            if (last.father.lchild.lchild == null){
                node.father = last.father.lchild;
                last.father.lchild.lchild = node;
            }
            else if(last.father.father.rchild.lchild == null){
                node.father = last.father.father.rchild;
                last.father.father.rchild.lchild = node;
            }
            else{
                int n = N/2;
                while(n > 3){
                    n = n/2;
                }
                BTreeNode tmp = new BTreeNode();
                if(n == 2) {
                    tmp.father = first;
                    tmp = first.rchild;
                    while(tmp.lchild != null);
                        tmp = tmp.lchild;
                    node.father = tmp;
                    tmp.lchild = node;
                }
                if(n == 3){
                    tmp.father = first;
                    tmp = first.lchild;
                    while(tmp.lchild != null)
                        tmp = tmp.lchild;
                    node.father = tmp;
                    tmp.lchild =node;
                }
            }

        }
        node.lchild = null;
        node.rchild = null;
        last = node;
        swim(node);
        N++;
    }

    public Item delMax(){
        //sink(first);//重新恢复堆有序
        Item max = first.item;
        exch(first,last); //交换堆顶和叶子结点的值
        BTreeNode lastfather = new BTreeNode();
        lastfather = last.father;
        if(last.father.lchild == null){ //只剩一个元素
            last = lastfather;
        }
        else if(lastfather.rchild == null) {  //最后一个元素是某结点的左叶子结点
            if(lastfather.father.lchild.rchild != null){
                lastfather.lchild = null;
                last = lastfather.father.lchild.rchild;
            }
            else{
                int n = N/2;
                while(n > 3){
                    n = n/2;
                }
                lastfather.lchild = null;
                BTreeNode tmp = new BTreeNode();
                if(n == 2) {
                    tmp = first;
                    while(tmp.rchild != null);
                        tmp = tmp.rchild;
                    last = tmp;
                }
                if(n == 3){
                    tmp = first;
                    while(tmp.lchild != null)
                        tmp = tmp.lchild;
                    last = tmp;
                }
            }
        }
        else{   //最后一个元素是某结点的右叶子结点
            last = last.father.lchild;
            last.father.rchild = null;
            last.lchild = null;
        }
        N--;
        sink(first);//重新恢复堆有序
        return max;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        ex2_4_24 hahaha = new ex2_4_24(input[0]);
        for (int i =1;i < input.length;i++)
            hahaha.insert(input[i]);
        System.out.println(hahaha.size());
        System.out.println(hahaha.isEmpty());
        for (int i =0;i < input.length;i++)
            System.out.print(hahaha.delMax()+" ");
        System.out.println();
        System.out.println(hahaha.isEmpty());
    }
}
