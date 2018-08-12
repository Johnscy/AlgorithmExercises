package LeetCode;
import Target_To_Offer.Merge;

import java.util.*;

/**
 * Given a n-ary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfNAryTree_559 {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    //DFS
    class Solution {
        private int maxDepth = 0;
        public int maxDepth(Node root) {
            if (root == null)
                return 0;
            dFS(root,1);
            return maxDepth;
        }
        private void dFS(Node node, int depth){
            if (node == null)   return;
            maxDepth = maxDepth > depth ? maxDepth : depth;
            for (Node k : node.children) {
                dFS(k,depth + 1);
            }
        }
    }

    //只有更简洁
    class Solution_clear {
        public int maxDepth(Node root) {
            int max = 0;
            if (root == null) return max;
            for (Node child : root.children) {
                max = Math.max(max, maxDepth(child));
            }
            return max + 1;
        }
    }
}
