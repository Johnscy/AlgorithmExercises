package Target_To_Offer;
import java.util.ArrayList;

/**
 *输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPath {
     public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
     }

     //递归版
    public class Solution {
        private ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
            backtracking(root,target,new ArrayList<Integer>());
            return arrayList;
        }
        private void backtracking(TreeNode node, int target, ArrayList<Integer> path){
            if (node == null)   return;
            path.add(node.val);
            target -= node.val;
            if (target == 0 && node.left == null && node.right == null)
                arrayList.add(new ArrayList<Integer>(path));
            else{
                backtracking(node.left,target,path);
                backtracking(node.right,target,path);
            }
            path.remove(path.size() - 1);
        }
    }

    //非递归版
}
