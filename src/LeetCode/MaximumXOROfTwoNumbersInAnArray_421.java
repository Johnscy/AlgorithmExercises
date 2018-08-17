package LeetCode;

import java.util.HashSet;

/**
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 2^31.
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * Could you do this in O(n) runtime?
 *
 * Example:
 * Input: [3, 10, 5, 25, 2, 8]
 * Output: 28
 * Explanation: The maximum result is 5 ^ 25 = 28.
 */
public class MaximumXOROfTwoNumbersInAnArray_421 {
    //bit manipulation and HashMap
    //按位找当前位异或最大值，然后拼接起来，查询在数组中存不存在，存在的话记录下当前最大值，往后继续。！！！！！
    //按位遍历，题目中给定了数字的返回不会超过2^31,那么最多只能有32位。
    // 我们用一个从左往右的mask，用来提取数字的前缀，然后将其都存入HashSet中。
    // 我们用一个变量t，用来验证当前位为1再或上之前结果res，看结果和HashSet中的前缀异或之后在不在HashSet中，
    // 这里用到了一个性质，若a^b=c，那么a=b^c，
    // 因为t是我们要验证的当前最大值，所以我们遍历HashSet中的数时，和t异或后的结果仍在HashSet中，
    // 说明两个前缀可以异或出t的值，所以我们更新res为t，继续遍历。
    class Solution_BitManipulation {
        public int findMaximumXOR(int[] nums) {
            if (nums == null || nums.length < 2)
                return 0;
            int max = 0, mask = 0;
            for (int i = 31; i >= 0; i--) {
                mask = mask | (1 << i);
                HashSet<Integer> hashSet = new HashSet<>();
                for (int num : nums)
                    hashSet.add(mask & num);
                int t = max | (1 << i); //（要使结果尽可能大，那就是异或后每位都是1）将之前的异或最大值结果和当前位的“1”拼接起来，去查询可不可以得出此结果！！
                for (int prefix : hashSet){
                    if (hashSet.contains(prefix ^ t)){
                        max = t;    //可以得出t的结果，将max更新为t
                        break;
                    }
                }
            }
            return max;
        }
    }

    //Trie树
    class Solution_Trie {
        private int maxRes = Integer.MIN_VALUE;
        class Trie{
            private Trie[] children;
            Trie(){
                children = new Trie[2]; //两种情况，分别为代表该位为0和1
            }
            private void insert(Trie curNode, int num){
                int curBit = 0;
                for (int i = 31; i >= 0; i--) {
                    curBit = (num >>> i) & 1;
                    if (curNode.children[curBit] == null)
                        curNode.children[curBit] = new Trie();
                    curNode = curNode.children[curBit];
                }
            }
            private void query(Trie curNode, int num){
                int curSum = 0;
                for(int i = 31; i >= 0; i --) {
                    int curBit = (num >>> i) & 1;
                    if(curNode.children[curBit ^ 1] != null) {  //当每位和当前输入数字反码的节点存在时
                        curSum += (1 << i);     //累加每位异或值
                        curNode = curNode.children[curBit ^ 1];
                    }else {
                        curNode = curNode.children[curBit];
                    }
                }
                maxRes = Math.max(curSum,maxRes);
            }
        }
        public int findMaximumXOR(int[] nums) {
            if (nums == null || nums.length < 2)
                return 0;
            Trie root = new Trie();
            for (int i = 0; i < nums.length; i++)
                root.insert(root,nums[i]);
            for (int i = 0; i < nums.length; i++) {
                root.query(root,nums[i]);
            }
            return maxRes;
        }
    }
}
