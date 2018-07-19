package Target_To_Offer;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNext {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    //中序：左根右。。。。
    // 思路：
    //（1） 若该节点存在右子树：则下一个节点为右子树最左子节点
    //（2） 若该节点不存在右子树：这时分两种情况：
    //2.1 该节点为父节点的左子节点，则下一个节点为其父节点
    //2.2 该节点为父节点的右子节点，则沿着父节点向上遍历，知道找到一个节点的父节点的左子节点为该节点，则该节点的父节点下一个节点。
    public class Solution {
        public TreeLinkNode GetNext(TreeLinkNode pNode) {
            if (pNode == null || (pNode.left == null && pNode.right == null && pNode.next == null))
                return null;
            TreeLinkNode node;
            if (pNode.right != null) {
                node = pNode.right;
                while (node.left != null)
                    node = node.left;
                return node;
            }
            else {
                node = pNode;
                while (node.next != null){
                    TreeLinkNode parent = node.next;
                    if (parent.left == node)
                        return parent;
                    node = node.next;
                }
            }
            return null;
        }
    }
}
