package leetcode75;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidTest {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{3, 5, -6, 2, -1, 4})));
        //[-6,2,4]
        //[3, 2, 4]

    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int i : asteroids) {
            boolean isAlive = true;

            while (i < 0 && !stack.isEmpty() && stack.peek() > 0 && isAlive) {

                if (-i  >= stack.peek()) {
                    stack.pop();

                } else if (-i == stack.peek()) {
                    stack.pop();
                    isAlive = false;

                } else {
                    isAlive = false;
                }


            }
            if (isAlive) {
                stack.push(i);
            }
        }
        int res[] = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;


    }
}
