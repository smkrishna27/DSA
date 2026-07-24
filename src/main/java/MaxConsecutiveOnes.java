public class MaxConsecutiveOnes {

    public int maxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;

        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count=0;
            } else {
                count++;
            }

            if (count > max) {
                max = count;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes mc = new MaxConsecutiveOnes();
        System.out.println(mc.maxConsecutiveOnes(new int[]{1, 1, 1, 1}));
        System.out.println(mc.maxConsecutiveOnes(new int[]{1,1,0,1}));
        System.out.println(mc.maxConsecutiveOnes(new int[]{1,1,1,0,1,1,1,1,0,1,1,1,1,1}));
    }
}
