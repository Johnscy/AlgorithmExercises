package Algotithms_Fourth_Edition.Chapter1;
import edu.princeton.cs.algs4.StdIn;
import java.util.*;

public class ex1_3_4 {
    public static void main(String args[]){
        Stack<String> stack =   new Stack<>();
        String string   =   StdIn.readString();
        String[] inputs =   string.split("");
        int count = 0;  //用来计左括号的数目，每有一个括号配对，减1.防止出现输入“(((”而不报错的情况。
        for (String input : inputs){
            if(input.equals("[") || input.equals("{") || input.equals("(")) {
                stack.push(input);
                count++;
            }
            else if (stack.isEmpty()) {
                    System.out.print("false");
                    return;
            } else {
                        switch (input) {
                            case ("]"):
                                if (!stack.pop().equals("[")) {
                                    System.out.println("false");
                                    return;
                                }break;
                            case ("}"):
                                if (!stack.pop().equals("{")) {
                                    System.out.println("false");
                                    return;
                                }break;
                            case (")"):
                                if (!stack.pop().equals("(")) {
                                    System.out.println("false");
                                    return;
                                }break;
                            default: {
                                System.out.println("input error");
                                return;
                            }

                        }
                        count--;

                    }

        }
        if(count==0)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
