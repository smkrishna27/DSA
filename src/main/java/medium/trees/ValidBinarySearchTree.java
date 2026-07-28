package medium.trees;

public class ValidBinarySearchTree {

    public static void main(String[] args) {

    }

    public static boolean validBST(TreeNode root) {
        if (root == null) return true;
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validate(TreeNode root, int minValue, int maxValue) {
        if (root == null) return true;
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return validate(root.left, minValue, root.val) &&
                validate(root.right, root.val, maxValue);


    }
}
