package Algotithms_Fourth_Edition.Chapter2;

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


}