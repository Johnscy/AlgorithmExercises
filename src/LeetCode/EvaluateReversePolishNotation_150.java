package LeetCode;
import java.util.*;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Note:
 *
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid.
 * That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 *
 * Example 1:
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 * Example 2:
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 *
 * Example 3:
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class EvaluateReversePolishNotation_150 {
    //Stack
    class Solution_Stack {
        public int evalRPN(String[] tokens) {
            if(tokens == null || tokens.length == 0)
                return 0;
            Stack<Integer> stack = new Stack<>();
            for(String s : tokens){
                try{
                    int num = Integer.parseInt(s);
                    stack.push(num);
                }catch(Exception e){
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(caculate(a,b,s));
                }
            }
            return stack.pop();
        }
        private int caculate(int a, int b, String s){
            switch(s){
                case "+":
                    return a + b;
                case "-":
                    return a - b;
                case "*":
                    return a * b;
                case "/":{
                    if(b != 0)
                        return a / b;
                }
                default:
                    return 0;
            }
        }
    }

    //直接用数组存，更快
    class Solution_Array {
        public int evalRPN(String[] tokens) {
            if(tokens == null || tokens.length == 0)
                return 0;
            int[] stack = new int[tokens.length / 2 + 1];
            int p = 0;
            for (String s : tokens) {
                switch(s) {
                    case "+":
                        p--;
                        stack[p - 1] = stack[p] + stack[p - 1];
                        break;
                    case "-":
                        p--;
                        stack[p - 1] = stack[p - 1] - stack[p];
                        break;
                    case "*":
                        p--;
                        stack[p - 1] = stack[p] * stack[p - 1];
                        break;
                    case "/":
                        p--;
                        if (stack[p] != 0)
                            stack[p - 1] = stack[p - 1] / stack[p];
                        break;
                    default:
                        stack[p++] = Integer.parseInt(s);
                }
            }
            return stack[0];
        }
    }
}
