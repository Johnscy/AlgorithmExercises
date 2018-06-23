package Target_To_Offer;
import java.util.HashMap;
/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

public class ReconstructBinaryTree{
    //Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class Solution {
        private HashMap<Integer, Integer> inOrderNumsIndexs = new HashMap<>(); // 缓存中序遍历数组的每个值对应的索引
        public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
            if(pre == null || in == null || pre.length != in.length || in.length <= 0)
                return null;
            for (int i = 0;i < in.length;i++)
                inOrderNumsIndexs.put(in[i],i);     //将中序遍历数组存入
            return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        }
        private TreeNode reConstructBinaryTree(int[] pre ,int preS, int preE, int[] in, int inS, int inE){
            if (preS > preE)    return null;
            TreeNode root = new TreeNode(pre[preS]);
            int index = inOrderNumsIndexs.get(root.val);
            int leftTreeSize = index - inS;
            root.left = reConstructBinaryTree(pre,preS+1,preS+leftTreeSize,in,inS,index-1);
            root.right = reConstructBinaryTree(pre,preS+leftTreeSize+1,preE,in,index+1,inE);
            return root;
        }
    }
}

