package slidingWindow;

public class MaximumSumOfSubarraysSizeK {

    public static void main(String[] args) {

        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;

        System.out.println(maxSumSubarray(nums, k));

    }

    public static int maxSumSubarray(int[] nums, int k) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (end - start + 1 == k) {
                sum -= nums[start];
                start++;
            }
        }


        return maxSum;

    }
}
