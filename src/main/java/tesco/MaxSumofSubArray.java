package tesco;

public class MaxSumofSubArray {

    public static void main(String[] args) {

        System.out.println(maxSubArray(new int[]{2, 1, 5, 1, 3, 2}, 3));

    }

    public static int maxSubArray(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (right = 0; right < nums.length; right++) {
            sum += nums[right];
            if (right - left + 1 == k) {
                maxSum = Math.max(sum, maxSum);
                sum -= nums[left];
                left++;
            }


        }
        return maxSum;

    }
}
