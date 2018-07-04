package Target_To_Offer;
import java.util.ArrayList;
import java.util.Stack;


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
    public class Solution_recursion {
        private ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
            backtracking(root,target,new ArrayList<Integer>());
            return arrayList;
        }

        private void backtracking(TreeNode node, int target, ArrayList<Integer> path){
            if (node == null)   return;
            path.add(node.val); //把结点的值加入路径中
            target -= node.val;
            if (target == 0 && node.left == null && node.right == null)
                arrayList.add(new ArrayList<Integer>(path));
            else{
                backtracking(node.left,target,path);
                backtracking(node.right,target,path);
            }
            path.remove(path.size() - 1);   //递归到叶子节点如果还没有找到路径，就要回退到父节点继续寻找
        }
    }

    //非递归版
    //用栈来存结点，用ArrayList来存值
    public class Solution {
        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
            ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            ArrayList<Integer> path = new ArrayList<>();
            while (root != null || !stack.isEmpty()){
                while (root != null) {  //入栈
                    stack.push(root);
                    path.add(root.val);
                    target -= root.val;
                    root = (root.left != null ? root.left : (root.right != null ? root.right : null));  //能左就左，否则就右。
                }
                root = stack.peek();    //栈顶元素
                if (root.left == null && root.right == null && target == 0) //如果和为target，且左右子树都为空（叶子结点），把路径加入
                    arrayList.add(new ArrayList<>(path));   //!!!!!一定要new，否则会被后面的步骤把值清空
                stack.pop();path.remove(path.size() - 1);target += root.val; //如果不满足，就把结点弹栈，值抛出，修正路径和（把原来减掉的这个结点的值加上）
                if (!stack.isEmpty() && stack.peek().left == root)
                    root = stack.peek().right;
                else
                    root = null;
            }
            return arrayList;
        }
    }

}
