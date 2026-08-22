package medium.trees;

public class KthSmallestIntegerInBST {
    static int result = 0;
    static int count = 0;

    public static void main(String[] args) {

        System.out.println(digitalRoot(1200000000));


    }

    public static int digitalRoot(int n) {
        while (n >= 10) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
        }
        return n;
    }

    public static int kthSmallest(TreeNode root, int k) {

        if (root == null) return -1;
        inOrder(root, k);
        return result;
    }

    private static void inOrder(TreeNode root, int k) {
        if (root == null) return;
        inOrder(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        inOrder(root.right, k);

    }
}
