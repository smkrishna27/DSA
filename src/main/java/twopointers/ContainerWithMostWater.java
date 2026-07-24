package twopointers;

public class ContainerWithMostWater {


    public static void main(String[] args) {
        //heights = [3, 4, 1, 2, 2, 4, 1, 3, 2]
        //21

        System.out.println(max_area(new int[]{3, 4, 1, 2, 2, 4, 1, 3, 2}));

    }

    public static Integer max_area(int[] heights) {

        int max = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            max = Math.max(area, max);
            if (heights[left] <= heights[right]) {
                left++;

            } else {
                right--;
            }


        }
        return max;


    }
}
