package Target_To_Offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetrical {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
    //递归
    //1.只要pRoot.left和pRoot.right是否对称即可
    //2.左右节点的值相等且对称子树left.left， right.right ;left.rigth,right.left也对称
    public class Solution_Recursion {
        boolean isSymmetrical(TreeNode pRoot) {
            if (pRoot == null)
                return true;
            return comNode(pRoot.left,pRoot.right);
        }
        private boolean comNode(TreeNode left, TreeNode right){
            if (left == null)
                return right == null;
            else if (right == null)
                return false;
            if (left.val != right.val)
                return false;
            return comNode(left.left,right.right) && comNode(left.right,right.left); //!!!!
        }
    }

    //DFS，栈
    // DFS使用stack来保存成对的节点
    //1.出栈的时候也是成对成对的，
    //       1.若都为空，继续；
    //      2.一个为空，返回false;
    //      3.不为空，比较当前值，值不等，返回false；
    //2.确定入栈顺序，每次入栈都是成对成对的，如left.left，right.right;left.rigth,right.left。
    public class Solution_DFS {
        boolean isSymmetricalDFS(TreeNode pRoot) {
            if (pRoot == null)
                return true;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(pRoot.left);
            stack.push(pRoot.right);
            while (!stack.isEmpty()){
                TreeNode right = stack.pop();
                TreeNode left = stack.pop();
                if (left == null && right == null)
                    continue;
                if (left == null || right == null)
                    return false;
                if (left.val != right.val)
                    return false;
                //成对压栈
                stack.push(left.left);
                stack.push(right.right);
                stack.push(left.right);
                stack.push(right.left);
            }
            return true;
        }
    }
    //BFS，队列
    //BFS使用Queue来保存成对的节点，代码和上面极其相似
    //1.出队的时候也是成对成对的 
    //      1.若都为空，继续；
    //     2.一个为空，返回false;
    //     3.不为空，比较当前值，值不等，返回false；
    //2.确定入队顺序，每次入队都是成对成对的，如left.left， right.right ;left.rigth,right.left
    public class Solution_BFS {
        boolean isSymmetricalDFS(TreeNode pRoot) {
            if (pRoot == null)
                return true;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(pRoot.left);
            queue.offer(pRoot.right);
            while (!queue.isEmpty()){
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();
                if (left == null && right == null)
                    continue;
                if (left == null || right == null)
                    return false;
                if (left.val != right.val)
                    return false;
                //成对入队
                queue.offer(left.left);
                queue.offer(right.right);
                queue.offer(left.right);
                queue.offer(right.left);
            }
            return true;
        }
    }
}
