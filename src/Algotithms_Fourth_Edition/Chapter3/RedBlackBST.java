package Algotithms_Fourth_Edition.Chapter3;
import java.util.*;

public class RedBlackBST<Key extends Comparable<Key>,Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false; //结点Node的color属性
    private Node root;      //根结点

    private class Node{
        Key key;            //键
        Value val;          //相关联值
        Node left, right;   //左右子树
        int N;              //这棵子树中的结点总数
        boolean color;      //由其父结点指向它的链接的颜色

        Node(Key key, Value val, int N, boolean color){
            this.key    = key;
            this.val    = val;
            this.N      = N;
            this.color  = color;
        }
    }

    private boolean isRed(Node x){
        if (x == null)  return  false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if (x == null)  return 0;
        else            return x.N;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0)   x = x.left;
            else if (cmp > 0)   x = x.right;
            else                return x.val;
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value val){
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root,key,val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val){
        if (h == null)
            return new Node(key,val,1,RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0)        h.left = put(h.left,key,val);
        else if(cmp > 0)    h.right = put(h.right,key,val);
        else                h.val = val;
        ////////////////红黑树比二叉超找树多出来的东西/////////////////从插入结点的父结点开始遍历至根结点，检查每个结点的颜色
        if (isRed(h.right) && !isRed(h.left))       h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left))    h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))        flipColors(h);
        //////////////////////////////////////////////////////////////
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public void delete(Key key){
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        delete(root,key);
    }
    private Node delete(Node h, Key key){

    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");

    }
    private Node deleteMin(){

    }

    public Key floor(Key key){
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("calls floor() with empty symbol table");
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
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("calls ceiling() with empty symbol table");
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
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + k);
        }
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
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(root,key);
    }
    private int rank(Node x, Key key){
        if (x == null)      return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)        return rank(x.left,key);
        else if (cmp > 0)   return rank(x.right,key) + size(x.left) + 1;
        else                return size(x.left);
    }



}
