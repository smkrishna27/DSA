package medium.trees;

public class KthSmallestIntegerInBST {
    static int result = 0;
    static int count = 0;

    public static void main(String[] args) {

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
