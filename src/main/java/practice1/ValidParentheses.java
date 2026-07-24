package practice1;

import java.util.ArrayDeque;
import java.util.Deque;

//6. Valid parentheses — check balanced brackets using a Stack .
public class ValidParentheses {
    public static void main(String[] args) {

        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([(]{}"));

    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (c == '(') stack.push(')');
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }

        }
        return stack.isEmpty();

    }
}
