package Algotithms_Fourth_Edition.Chapter1;
import java.util.*;

public class InfixToPostfix {
    public static void main(String args[]) {
        Stack<String> stack = new Stack<String>();
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split("");
        for (String input : inputs) {
            if (input.equals("("))               //如果是开括号，压栈
                stack.push(input);
            else if (input.equals(")")) {         //如果是闭括号，判断堆栈是否为空。为空，则出错.
                if (!stack.isEmpty()) {          //非空，弹栈直到遇到第一个开括号，若无开括号，则出错。
                    String pop = stack.pop();
                    while (!pop.equals("(")) {
                        System.out.print(pop);
                        if (!stack.isEmpty())
                            pop = stack.pop();
                        else {
                            System.out.print("error");
                            return;
                        }
                    }
                } else {
                    System.out.print("error");
                    return;
                }
            }
            else if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {     //当输入是运算符op（+、- 、×、/）时候
                boolean isStackTopLowerPriority = false;
                boolean isLeftParen = false;
                if (!stack.isEmpty()) {
                    String ops = stack.peek();
                    isLeftParen = stack.peek().equals("(");
                    if ((input.equals("*") || input.equals("/")) && (ops.equals("+") || ops.equals("-")))
                        isStackTopLowerPriority = true;
                }
                if (!stack.isEmpty() && !isStackTopLowerPriority && !isLeftParen) {             //a)循环，当（栈非空and栈顶不是开括号and栈顶运算符的优先级不低于输入的运算符的优先级）时，反复操作：将栈顶元素出栈输出
                    while (!stack.isEmpty())
                        System.out.print(stack.pop());
                }
                stack.push(input);                                                      //b)把输入的运算符op压栈
            } else    //假设不输入其他乱七八糟的东西，恩，遵守基本法的输入。遇到数字直接打印。
                System.out.print(input);
        }
        while (!stack.isEmpty()) {
            String s = stack.pop();
            if (s.equals("(")) {            //当字符串读完，栈不空时，弹栈并打印。若弹出“（”则报错。
                System.out.print("error");
                break;
            } else
                System.out.print(s);
        }
        System.out.println();
    }
}
