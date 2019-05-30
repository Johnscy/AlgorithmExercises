package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 * Return a list of all possible full binary trees with N nodes.
 * Each element of the answer is the root node of one possible tree.
 * Each node of each tree in the answer must have node.val = 0.
 * You may return the final list of trees in any order.
 *
 * Example 1:
 * Input: 7
 * Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * Explanation:
 *
 * Note:
 * 1 <= N <= 20
 */
public class AllPossibleFullBinaryTrees_894 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //Recursion - bottom to up 递归到底层，从底层开始遍历每个结点的情况
    class Solution_RecursionBU {
        private HashMap<Integer,List<TreeNode>> map = new HashMap<>();  //用hashmap存储计算过得数字N对应的情况
        public List<TreeNode> allPossibleFBT(int N) {
            List<TreeNode> res = new LinkedList<>();
            if (N <= 0 || N % 2 == 0) return res;
            if (map.containsKey(N)) return map.get(N);  //如果N是计算过得情况，可从hashmap中直接取用结果res
            if (N == 1){
                res.add(new TreeNode(0));
                return res;
            }
            for (int i = 1; i < N - 1; i+= 2) {
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(N - 1 - i); //去掉左右子树的父结点
                for (TreeNode leftNode : left){
                    for (TreeNode rightNode : right){
                        TreeNode cur = new TreeNode(0);
                        cur.left = leftNode;
                        cur.right = rightNode;
                        res.add(cur);
                    }
                }
            }
            if (N < 30)
                map.put(N,res);
            return res;
        }
            
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(new AllPossibleFullBinaryTrees_894().new Solution_RecursionBU().allPossibleFBT(N));
    }
}
