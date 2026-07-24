package capitalone;

import java.util.Stack;

public class MinimumElementStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        }  else {
            minStack.push(minStack.peek());
        }
    }
    public void pop() {
        if (stack.isEmpty()) return ;
      stack.pop();
      minStack.pop();
    }
    public int peek() {
        return stack.peek();
    }


    public int min() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinimumElementStack stack = new MinimumElementStack();
        stack.push(9);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        System.out.println(stack.min());
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
    }



}
