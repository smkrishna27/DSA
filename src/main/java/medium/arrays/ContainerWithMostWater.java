package medium.arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{3, 4, 1, 2, 2, 4, 1, 3, 2}));

    }

    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right] * (right - left));
            max = Math.max(area, max);
            if (height[left] <= height[right]) {
                left++;

            } else {
                right--;
            }
        }
        return max;


    }
}
