package medium.stackqueueandheap;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    //Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]
    //
    //Output: 3

    public static void main(String[] args) {

        System.out.println(carFleet(10, new int[]{4, 1, 0, 7}, new int[]{2, 2, 1, 1}));

    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for (double[] car : cars) {
            double time = car[1];
            // If current car takes longer, it forms a new fleet
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // Otherwise, it merges with the fleet ahead (no push)
        }
        return stack.size();
    }
}
