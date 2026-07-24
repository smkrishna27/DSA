package slidingWindow;

public class MaxPointsYouCanObtainFromCards {

    public static void main(String[] args) {
        int[] cards = {2, 11, 4, 5, 3, 9, 2};
        int k = 3;
        //output 17;

        System.out.println(maxPoints(cards, k));


    }

    public static int maxPoints(int[] nums, int k) {

        int max = 0;
        if (nums == null || nums.length == 0) {
            return max;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = 0;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int n = nums.length - k;
        for (int i = 0; i < n; i++) {
            sum += nums[i];  //17
        }
        int minsum = sum;
        for (int i = n; i < nums.length; i++) {
            minsum += nums[i] - nums[i - n];
            max = Math.max(max, total - minsum);
        }


        return max;


    }
}
