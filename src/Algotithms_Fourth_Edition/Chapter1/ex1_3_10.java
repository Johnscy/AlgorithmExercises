package Algotithms_Fourth_Edition.Chapter1;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.util.*;

public class ex1_3_10 {
     static void InfixToPostfix(String expression){
        Stack<String> stack = new Stack<>();
        String[] inputs = expression.split("");
        for(String input : inputs){
            if(input.equals("("))               //如果是开括号，压栈
                stack.push(input);
            else if(input.equals(")")){         //如果是闭括号，判断堆栈是否为空。为空，则出错.
                if(!stack.isEmpty()) {          //非空，弹栈直到遇到第一个开括号，若无开括号，则出错。
                    String pop = stack.pop();
                    while (!pop.equals("(")) {
                        StdOut.print(pop);
                        if(!stack.isEmpty())
                            pop = stack.pop();
                        else{
                            StdOut.print("error");
                            return;
                        }
                    }
                } else{
                    StdOut.print("error");
                    return;
                }
            }else if(input.equals("+") ||input.equals("-") || input.equals("*") || input.equals("/")) {
                boolean isLowerPriority = false;
                boolean isLeftParen = false;
                if(!stack.isEmpty()) {
                    String ops = stack.peek();
                    isLeftParen = stack.peek().equals("(");
                    if ((input.equals("*") || input.equals("/")) && ops.equals("+") || ops.equals("-"))
                        isLowerPriority = true;
                }
                if (!(stack.isEmpty() || isLowerPriority || isLeftParen)) {
                    while (!stack.isEmpty())
                        StdOut.print(stack.pop());
                }
                stack.push(input);

            }
            else    //假设不输入其他乱七八糟的东西，恩，遵守基本法的输入
                StdOut.print(input);
        }
        while(!stack.isEmpty()){
            String s =stack.pop();
            if(s.equals("(")){
                StdOut.print("error");
                break;
            }
            else
                StdOut.print(s);
        }

    }

    public static void main(String args[]){
        String str = StdIn.readString();
        InfixToPostfix(str);
    }
}
