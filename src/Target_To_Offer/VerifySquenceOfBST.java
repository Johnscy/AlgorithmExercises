package Target_To_Offer;

/**
 *输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 思路：BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，
 * 那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。
 * 完美的递归定义 : ) 。
 */
public class VerifySquenceOfBST {
    public class Solution {
        public boolean VerifySquenceOfBST(int [] sequence) {
            if (sequence == null || sequence.length == 0)
                return false;
            int len = sequence.length;
            return verify(sequence,0,len - 1);
        }
        private boolean verify(int[] sequence, int start, int end){
            if (start >= end)   return true;
            int rootIndex = end;
            int rootVal = sequence[end];    //根结点的值。比右子树小，比左子树大。
            while (rootIndex > start && sequence[rootIndex - 1] > rootVal)    //找到左右子树的分界处：左子树小于root，右子树大于root。
                rootIndex--;                                                        //rootIndex - 1为左子树的根结点
            for (int i = rootIndex - 1;i >= start;i--)
                if (sequence[i] > rootVal)
                    return false;
            return verify(sequence,start,rootIndex - 1) && verify(sequence,rootIndex,end - 1);//在左子树和右子树中继续递归
        }
    }
}
