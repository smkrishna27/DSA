package medium.stackqueueandheap;

import java.util.Stack;

public class MinStack {

    Stack<Integer> main;
    Stack<Integer> min;

    MinStack() {
        main = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        main.push(val);
        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }

    }

    public void pop() {
        int val = main.pop();
        if (val == min.peek())
            min.pop();

    }

    public int top() {
        if (main.isEmpty()) return -1;
        return main.peek();

    }

    public int getMin() {
        if (min.isEmpty()) return -1;
        return min.peek();

    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(4);
        minStack.push(6);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }


}
