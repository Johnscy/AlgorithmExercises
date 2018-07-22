package Target_To_Offer;
import java.util.*;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintFromLeftToRightThenRightToLeft {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //BFS，Queue
    public class Solution_BFS {
        public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            if (pRoot == null)
                return res;
            Queue<TreeNode> q = new LinkedList<>();
            Stack<Integer> s = new Stack<>();  //用来逆序
            boolean left2Rignt = true;
            q.offer(pRoot); //根结点加入，从左到右打印。
            int cnt = 0;    //每层的结点数
            while (!q.isEmpty()){
                ArrayList<Integer> list = new ArrayList<>();
                cnt = q.size();
                while (cnt -- > 0) {
                    TreeNode node = q.poll();
                    if (!left2Rignt)
                        s.push(node.val);
                    else
                        list.add(node.val);
                    if (node.left != null)
                        q.offer(node.left);
                    if (node.right != null)
                        q.offer(node.right);
                    //q.offer(left2Rignt ? node.left : node.right);
                    //q.offer(left2Rignt ? node.right : node.left);
                }
                left2Rignt = !left2Rignt;
                while (!s.isEmpty())
                    list.add(s.pop());
                if (list.size() != 0)
                    res.add(list);
            }
            return res;
        }
    }
}
