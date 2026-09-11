package medium.trees;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {

    }

    private static int maxSum = Integer.MIN_VALUE;


    public static int maxPathSum(TreeNode root) {

        dfs(root);
        return  maxSum;


    }

    private static int dfs(TreeNode root) {

        if (root == null)
            return 0;

        int leftGain = Math.max(dfs(root.left), 0);
        int rightGain = Math.max(dfs(root.right), 0);
        int curr = leftGain + rightGain + root.val;
        maxSum = Math.max(curr, maxSum);

        return root.val + Math.max(leftGain, rightGain);


    }
}
