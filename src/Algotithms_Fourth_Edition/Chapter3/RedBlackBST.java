package Algotithms_Fourth_Edition.Chapter3;

public class RedBlackBST<Key extends Comparable<Key>,Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false; //结点Node的color属性
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
    private Node root;      //根结点

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

    public void put(Key key, Value val){
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
        //红黑树比二叉超找树多出来的东西
        if (isRed(h.right) && !isRed(h.left))       h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left))    h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))        flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }


}
