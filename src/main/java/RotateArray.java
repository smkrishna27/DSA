public class RotateArray {
    public static void main(String[] args) {
        //Reverese Array
        //Reverese first K nos
        //Reverese last n-k nos

        RotateArray rotateArray = new RotateArray();
        int arr[] = new int[] {1,2,3,4,5,6,7,8,9,10};
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);

        }
        System.out.println();
        rotateArray.rotate( arr, 5);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }


    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return;
        }
        k= k%nums.length;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    void reverse(int[] nums, int start, int end) {

        int i = start, j = end;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
