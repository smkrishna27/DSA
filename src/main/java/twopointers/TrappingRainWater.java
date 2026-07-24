package twopointers;

public class TrappingRainWater {
    public static void main(String[] args) {

        System.out.println(trap(new int[]{3, 4, 1, 2, 2, 5, 1, 0, 2}));
        System.out.println(trap(new int[]{1,0,2,0,0,3,1}));

    }

    public  static int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        int maxLeft = 0;
        int maxRight = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > maxLeft) {
                    maxLeft = Math.max(maxLeft, height[left]);
                } else {
                    ans += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] > maxRight) {
                    maxRight = Math.max(maxRight, height[right]);
                } else {
                    ans += maxRight - height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
