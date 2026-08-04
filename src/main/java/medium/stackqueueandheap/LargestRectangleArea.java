package medium.stackqueueandheap;

import java.util.Stack;

public class LargestRectangleArea {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 2, 2, 2}));
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {

            int currentHeight = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }


            stack.push(i);


        }


        return maxArea;

    }
}
