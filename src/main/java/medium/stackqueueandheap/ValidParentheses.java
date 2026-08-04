package medium.stackqueueandheap;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        //{[()]}
        System.out.println(isValidParentheses("{[()]}"));

    }

    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)) {
                case ('{'):
                    stack.push('}');
                    break;
                case ('('):
                    stack.push(')');
                    break;

                case ('['):
                    stack.push(']');
                    break;
                default:
                    if (!stack.isEmpty() && s.charAt(i) != stack.pop()) {
                        return false;
                    }
                    break;
            }

          /*  if (s.charAt(i) == '{') stack.push('}');
            else if (s.charAt(i) == '(') stack.push(')');
            else if (s.charAt(i) == '[') stack.push(']');
            else if (!stack.isEmpty() && s.charAt(i) != stack.pop()) {
                return false;
            }*/


        }
        return true;


    }
}
