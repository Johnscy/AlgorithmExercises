package Target_To_Offer;
import java.util.ArrayList;
import java.util.Stack;

/**
 *输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * 思路：用栈来模拟情况
 */
public class IsPopOrder {
    public class Solution {
        public boolean IsPopOrder(int [] pushA,int [] popA) {
            Stack<Integer> stack = new Stack<>();
            int n = pushA.length;   //两序列长度一样
            for (int pushIndex = 0,popIndex = 0;pushIndex < n;pushIndex++){
                stack.push(pushA[pushIndex]);
                while (popIndex < n && stack.peek() == popA[popIndex]){    //一直压栈，直到栈顶元素等于弹栈数组的第一个元素
                    stack.pop();                                            //然后弹栈，弹栈数组的索引+1
                    popIndex++;
                }
            }
            return stack.isEmpty(); //如果最后栈空了，说明第二个序列是该栈的弹出序列。
        }
    }
}
