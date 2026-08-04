package medium.stackqueueandheap;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {


    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                int previousIndex = stack.pop();
                result[previousIndex] = i - previousIndex;
            }

            stack.push(i);

        }
        return result;


    }

    public static void main(String[] args) {
        //Input: temperatures = [30,38,30,36,35,40,28]
        //
        //Output: [1,4,1,2,1,0,0]
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 38, 30, 36, 35, 40, 28})));

    }
}
