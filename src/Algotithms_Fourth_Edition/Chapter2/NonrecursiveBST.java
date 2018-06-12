package Algotithms_Fourth_Edition.Chapter2;
import java.util.*;

public class NonrecursiveBST<Key extends Comparable<Key>,Value>{
    // root of BST
    private Node root;
    private class Node {
        private Key key;             // sorted by key
        private Value val;           // associated value
        private Node left, right;    // left and right subtrees
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size(Node x){
        if (x == null)  return 0;
        else            return x.N;
    }
    /***************************************************************************
     *  Insert key-value pair into symbol table (nonrecursive version).
     ***************************************************************************/
    public void put(Key key, Value val) {
        Node z = new Node(key, val,1);
        if (root == null) {
            root = z;
            return;
        }

        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else {
                x.val = val;
                x.N = size(x.left) + size(x.right) + 1;
                return;
            }
        }
        int cmp = key.compareTo(parent.key);    //如果之前没有key这个键，新建结点插入parent的左/右子树中
        if (cmp < 0) parent.left  = z;
        else         parent.right = z;
        x.N = size(x.left) + size(x.right) + 1;
    }

    /***************************************************************************
     *  Search BST for given key, nonrecursive version.
     ***************************************************************************/
    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    /***************************************************************************
     *  Inorder traversal.
     ***************************************************************************/
    public Iterable<Key> keys() {
        Stack<Node> stack = new Stack<Node>();
        Queue<Key> queue = new LinkedList<Key>();
        Node x = root;
        while (x != null || !stack.isEmpty()) {
            if (x != null) {
                stack.push(x);
                x = x.left;
            }
            else {
                x = stack.pop();
                queue.offer(x.key);
                x = x.right;
            }
        }
        return queue;
    }

    /***************************************************************************
     *  Minimum key.
     ***************************************************************************/
    public Key min(Node x){
        //Node x = root;
        while (x.left != null)
            x = x.left;
        return x.key;
    }

    /***************************************************************************
     *  Maximum key.
     ***************************************************************************/
    public Key max(Node x){
        //Node x = root;
        while (x.right != null)
            x = x.right;
        return x.key;
    }

    /***************************************************************************
     *Key that smaller than or equal to "key"
     ***************************************************************************/
    public Key floor(Key key){
        if (key == null) throw new IllegalArgumentException("key is null");
        Node x = root;
        Key result = null;
        while (x != null){
            int cmp = key.compareTo(x.key);
            if (cmp == 0)            return x.key;
            else if (cmp < 0)        x = x.left;
            else {
                    result = x.key;
                    x = x.right;
//                Node t = x.right;
//                if (min(t).compareTo(key) > 0 || t == null) return x.key;
//                x = t;
            }
        }
        return result;
    }

    /***************************************************************************
     *Key that greater than or equal to "key"
     ***************************************************************************/
    public Key ceiling(Key key){
        if (key == null) throw new IllegalArgumentException("key is null");
        Node x = root;
        Key result = null;
        while (x != null){
            int cmp = key.compareTo(x.key);
            if (cmp == 0)            return x.key;
            else if (cmp > 0)        x = x.right;
            else{
                    result = x.key;
                    x = x.left;
//                Node t = x.left;
//                if (max(t).compareTo(key) < 0 || t == null) return x.key;
//                x = t;
            }
        }
        return result;
    }

    /***************************************************************************
     *Select the key whose rank is k
     ***************************************************************************/
    public Key select(int k){   //k从0开始。排名为k即树中有k个小于它的键。
        if (k < 0 || k > size(root))    return null;
        Node x = root;
        while (x != null){
            int t = size(x.left);
            if (t > k)          {x = x.left;}   // k = k
            else if (t < k)     {x = x.right;k = k - t - 1;} //k = k - t -1
            else                return x.key;
        }
        return null;
    }

    /***************************************************************************
     *Get the rank of the key
     ***************************************************************************/
    public int rank(Key key){   //小于key的键的个数
        Node x = root;
        if (x == null)  return 0;
        int rank = 0;
        while (x != null){
            int cmp = key.compareTo(x.key);
            if (cmp < 0)        {x = x.left;}
            else if (cmp > 0)   {rank += 1 + size(x.left);x = x.right;}
            else                return (rank + size(x.left));
        }
        return rank;
    }

    public static void main(String[] args){}
}
