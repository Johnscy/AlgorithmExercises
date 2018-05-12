package Algotithms_Fourth_Edition.Chapter1;
import java.util.*;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class ex1_3_11 {
    static Double EvaluatePostfix(String expression){
        String[] inputs = expression.split("");
        Stack<Double> stack = new Stack<>();
        for(String input : inputs){
                switch (input) {
                    case ("+"):
                        stack.push(stack.pop() + stack.pop());break;
                    case ("-"):
                        stack.push(-stack.pop() + stack.pop());break;
                    case ("*"):
                        stack.push(stack.pop() * stack.pop());break;
                    case ("/"): {
                        Double pop = stack.pop();
                        if ( pop== 0.0) {
                            StdOut.print("error");
                            break;
                        } else
                            stack.push(1 / pop * stack.pop());break;
                    }
                    default: stack.push(Double.parseDouble(input));
                }
        }
        return stack.pop();
    }

    public  static void main(String args[]){
        String str = StdIn.readString();
        StdOut.println(EvaluatePostfix(str));
    }

}
