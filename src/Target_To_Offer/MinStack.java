package Target_To_Offer;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到最小元素的min函数。（原题要求O(1)复杂度）
 * 思路：原题要求O(1)复杂度，所以用辅助栈来存到目前为止最小的元素。
 */
public class MinStack {
    public class Solution {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public void push(int node) {
            stack.push(node);
            minStack.push(minStack.isEmpty() ? node : Math.min(node,minStack.peek()));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}
