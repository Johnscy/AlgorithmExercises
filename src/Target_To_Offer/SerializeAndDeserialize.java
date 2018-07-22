package Target_To_Offer;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class SerializeAndDeserialize {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //前序遍历来序列化
    public class Solution {
        private String deserializeStr;
        String Serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            if (root == null) {
                sb.append("#,");
                return sb.toString();
            }
            sb.append(root.val + ",");
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));
            return sb.toString();
        }

        TreeNode Deserialize(String str) {
            if (str == null)
                return null;
            deserializeStr = str;
            TreeNode root = Deserialize();
            return root;
        }

        private TreeNode Deserialize() {
            if (deserializeStr.length() == 0)
                return null;
            int index = deserializeStr.indexOf(",");
            String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
            deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
            if (node.equals("#"))
                return null;
            int val = Integer.valueOf(node);
            TreeNode newNode = new TreeNode(val);
            newNode.left = Deserialize();
            newNode.right = Deserialize();
            return newNode;
        }
    }
}
