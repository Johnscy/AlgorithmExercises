package Algotithms_Fourth_Edition.Chapter1;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.*;
import java.lang.*;

public class ex1_3_9 {
    public static void main(String args[]){
        Stack<String> val = new Stack<>();
        Stack<String> ops = new Stack<>();
        String string = StdIn.readString();
        String[] inputs = string.split("");
        for(String input:inputs){
            if(input.equals("+") || input.equals("-") || input.equals("*") ||input.equals("/"))
                ops.push(input);
            else if(input.equals(")")){
                String val_temp1 = val.pop();
                String val_temp2 = val.pop();
                val.push("(" + val_temp2 + ops.pop() + val_temp1 + ")");
            }
            else
                val.push(input); //不要乱输入一些奇怪的东西。。。输入也要按照基本法，，，懒得写各种异常情况了XD
        }

        StdOut.print(val.pop());
    }
}
