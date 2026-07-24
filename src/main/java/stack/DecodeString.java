package stack;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        //"aaabcbc"

        System.out.println(decodeString(s));

    }

    public static String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0'); // build multiplier
            } else if (c == '[') {
                countStack.push(k);
                stringStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decoded = stringStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decoded.append(current);
                }
                current = decoded;
            } else {
                current.append(c); // add normal character
            }
        }
        return current.toString();


    }
}
