package medium.stackqueueandheap;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    //Input: tokens = ["1","2","+","3","*","4","-"]
    //
    //Output: 5
    //
    //Explanation: ((1 + 2) * 3) - 4 = 5

    public static void main(String[] args) {

        System.out.println(evalRPN(new String[]{"1", "2", "+", "3", "*", "4", "-"}));

    }

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {

            switch (s) {
                case "+":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(s));


            }

        }
        return stack.pop();

    }
}
