//package Algotithms_Fourth_Edition.Chapter1;
import java.util.*;


public class InfixToPrefix {
    private String[] string;
    InfixToPrefix(String[] string){
        this.string = string;
    }
    void reverseorder(String[] string){
        Stack<String> reverseStack = new Stack<String>();
        for (int i = 0;i < string.length;i++)
            reverseStack.push(string[i]);
        for (int i = 0;i < string.length;i++)
            string[i] = reverseStack.pop();
    }
    void makeInfixToPrefix(String[] string){
        Stack<String> stack = new Stack<String>();
        Stack<String> resultStack = new Stack<String>();
        reverseorder(string);
        for(String input : string){
            if(input.equals(")"))
                stack.push(input);
            else if(input.equals("(")){
                if (!stack.isEmpty()) {          //非空，弹栈直到遇到第一个闭括号，若无闭括号，则出错。
                    String pop = stack.pop();
                    while (!pop.equals(")")) {
                        resultStack.push(pop);//System.out.print(pop);//
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
                boolean isInputLowerPriority = false;
                boolean isRightParen = false;
                if (!stack.isEmpty()) {
                    String ops = stack.peek();
                    isRightParen = stack.peek().equals(")");
                    if ((input.equals("+") || input.equals("-")) && (ops.equals("*") || ops.equals("/")))
                        isInputLowerPriority = true;
                }
                if (!stack.isEmpty() && isInputLowerPriority && !isRightParen) {             //a)循环，当（栈非空and栈顶不是闭括号and输入的运算符的优先级低于栈顶运算符的优先级）时，反复操作：将栈顶元素出栈输出
                    while (!stack.isEmpty())
                        resultStack.push(stack.pop());//System.out.print(stack.pop());//
                }
                stack.push(input);                                                      //b)把输入的运算符op压栈
            } else    //假设不输入其他乱七八糟的东西，恩，遵守基本法的输入。遇到数字直接打印。
                resultStack.push(input);//System.out.print(input);//

        }
            while (!stack.isEmpty()) {
                String s = stack.pop();
                 if (s.equals(")")) {            //当字符串读完，栈不空时，弹栈并打印。若弹出“)”则报错。
                    System.out.print("error");
                    break;
                 } else
                     resultStack.push(s);//System.out.print(s);//
            }
        while(!resultStack.isEmpty())
            System.out.print(resultStack.pop());
        System.out.println();

    }
    public static void main(String args[]){
        Scanner sc  =   new Scanner(System.in);
        String[] string=sc.nextLine().split("");
        InfixToPrefix infixtoprefix = new InfixToPrefix(string);
        infixtoprefix.makeInfixToPrefix(string);
    }
}
