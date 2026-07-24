package roku;

import java.util.Stack;

public class FindMinimumValueFromStack {

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();


    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }

    }

    public void pop() {
        if (mainStack.isEmpty()) return;
        int removed = mainStack.pop();
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int getMin() {
        if(minStack.empty()){
            return -1;
        }
        return minStack.peek();
    }


    public static void main(String[] args) {
        FindMinimumValueFromStack findMinimumValueFromStack = new FindMinimumValueFromStack();
        findMinimumValueFromStack.push(1);
        findMinimumValueFromStack.push(3);
        findMinimumValueFromStack.push(4);
        findMinimumValueFromStack.push(2);

        System.out.println(findMinimumValueFromStack.getMin());
        findMinimumValueFromStack.pop();
        findMinimumValueFromStack.pop();
        findMinimumValueFromStack.pop();
        System.out.println(findMinimumValueFromStack.getMin());

    }

}
