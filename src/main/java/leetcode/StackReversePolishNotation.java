package leetcode;

import java.util.Stack;

public class StackReversePolishNotation {
    public static void main(String[] args) {
        StackReversePolishNotation stackReversePolishNotation = new StackReversePolishNotation();
        System.out.println(stackReversePolishNotation.evalRP(new String[]{"2", "1", "+", "3", "*"}));


    }

    public int evalRP(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> stack.push(stack.pop() - stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> stack.push(stack.pop() / stack.pop());
                default -> stack.push(Integer.valueOf(token));
            }


        }
        return stack.pop();
    }
}
