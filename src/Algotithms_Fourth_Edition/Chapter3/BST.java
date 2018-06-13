package Algotithms_Fourth_Edition.Chapter3;
import java.util.*;

/**
 * 用各种递归方法实现BST
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>,Value> {
    private class Node{
        private Key key;            //键
        private Value val;          //值
        private Node left, right;   //指向左右子树的链接
        private int N;              //以该结点为根的子树中的结点总数

        public Node(Key key, Value val, int N){
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }
    private Node root;  //根结点
    //API
    public int size(){
        return size(root);
    }
    private int size(Node x){
        if (x == null)  return 0;
        else            return x.N;
    }
    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node x, Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)        return get(x.left,key);
        else if (cmp > 0)   return get(x.right,key);
        else                return x.val;
    }
    public void put(Key key, Value val){
        root = put(root,key,val);
    }
    private Node put(Node x, Key key, Value val){
        if (x == null) return new Node(key,val,1);  //如果key不存在，则新建结点并插入子树中
        int cmp = key.compareTo(x.key);
        if (cmp < 0)        x.left = put(x.left,key,val);
        else if (cmp > 0)   x.right = put(x.right,key,val);
        else                x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){
        if (x.left == null) return x;
        return min(x.left);
    }
    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        if (x.right == null) return x;
        return max(x.right);
    }
    public Key floor(Key key){
        Node x = floor(root,key);
        if (x == null) return null;
        return x.key;
    }
    private Node floor(Node x, Key key){
        if (x == null)  return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)   return x;
        else if (cmp < 0)   return floor(x.left,key);
        Node t = floor(x.right,key);
        if (t != null)  return t;
        else            return x;
    }
    public Key ceiling(Key key){
        Node x = ceiling(root,key);
        if (x == null)  return null;
        return x.key;
    }
    private Node ceiling(Node x, Key key){
        if (x == null)  return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)   return x;
        else if (cmp > 0)   return ceiling(x.right,key);
        Node t = ceiling(x.left,key);
        if (t != null)  return t;
        else            return x;
    }
    public Key select(int k){
        return select(root,k).key;
    }
    private Node select(Node x, int k){
        if (x == null)  return null;
        int t =size(x.left);
        if (t > k)      return select(x.left,k);
        else if(t < k)  return select(x.right,k-(t+1));
        else            return x;
    }
    public int rank(Key key){
        return rank(root,key);
    }
    private int rank(Node x, Key key){
        if (x == null)      return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)        return rank(x.left,key);
        else if (cmp > 0)   return rank(x.right,key) + size(x.left) + 1;
        else                return size(x.left);
    }
    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node x){
        if (x.left == null) return x.right; //找到左子树为空的结点，这就是最小的元素，返回它的右子树
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void delete(Key key){
        root = delete(root,key);
    }
    private Node delete(Node x, Key key){
        if (x == null)  return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)        x.left = delete(x.left,key);
        else if (cmp > 0)   x.right = delete(x.right,key);
        else{
            if (x.right == null)    return x.left;
            if (x.left == null)     return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public Iterable<Key> keys(){
        return keys(min(),max());
    }
    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> queue = new LinkedList<Key>();
        keys(root,queue,lo,hi);
        return queue;
    }
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi){
        if (x == null)  return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0)  keys(x.left,queue,lo,hi);
        if (cmplo <= 0 && cmphi >= 0)   queue.offer(x.key);
        if (cmphi > 0)  keys(x.right,queue,lo,hi);
    }
    public void printLevel(){
        printLevel(root);
    }
    private void printLevel(Node x){
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(x);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println("Key:" + node.key+ " " +"Value:" + node.val);//访问节点
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }
    }

    public static void main(String[] args){

    }


}