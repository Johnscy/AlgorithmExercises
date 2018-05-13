package Algotithms_Fourth_Edition.Chapter1;
import java.util.*;


public class InfixToPrefix {
    String reverseorder(String[] string){
        Stack<String> stack = new Stack<>();
        while ()
    }
    void makeInfixToPrefix(String[] string){
        Stack<String> stack = new Stack<>();
        String[] inputs =reverseorder(string);
        for(String input :inputs) {
            if (input.equals(")"))
                stack.push(input);
            else if(input.equals("+") || input.equals("-") ||input.equals("*") || input.equals("/")){

            }
        }
    }
    public static void main(String args[]){
        Scanner sc  =   new Scanner(System.in);
        String[] str=sc.nextLine().split("");
        InfixToPrefix infixtoprefix = new InfixToPrefix();
        infixtoprefix.makeInfixToPrefix(str);
    }
}
