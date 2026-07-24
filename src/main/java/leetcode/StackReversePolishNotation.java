package leetcode;

import java.util.Stack;

public class StackReversePolishNotation {
    public static void main(String[] args) {
        StackReversePolishNotation  stackReversePolishNotation = new StackReversePolishNotation();
        System.out.println(stackReversePolishNotation.evalRP(new String[]{"2", "1", "+", "3", "*"}));


    }
    public int evalRP(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if(token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else if(token.equals("-")) {
                stack.push(stack.pop() -stack.pop());
            }
            else if(token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else if(token.equals("/")) {
                stack.push(stack.pop() / stack.pop());
            }
            else {
                stack.push(Integer.valueOf(token));
            }


        }
        return stack.pop();
    }
}
