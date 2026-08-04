package medium.arrays;

public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));

    }

    //[0,1,0,2,1,0,1,3,2,1,2,1] water=6
    public static int trap(int[] height) {

        int water = 0;
        int maxLeft = 0, maxRight = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                maxLeft = Math.max(maxLeft, height[left]); //max left
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    water += maxLeft - height[left];
                }
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    water += maxRight - height[right];
                }
                right--;
            }


        }

        return water;

    }
}
