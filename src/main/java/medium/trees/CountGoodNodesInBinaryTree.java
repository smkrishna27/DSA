package medium.trees;

import java.util.LinkedList;
import java.util.Queue;

public class CountGoodNodesInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(3);
        root.right = null;
        root.left.right = new TreeNode(6);
        System.out.println(goodNodes(root));

    }

    public static int goodNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return dfs(root, root.val);
    }

    private static int dfs(TreeNode root, int val) {

        int count = 0;
        if (root == null) return 0;
        if (root.val >= val) {
            count = 1;
        }
        int newMax = 0;
        newMax = Math.max(val, root.val);
        count += dfs(root.left, newMax);
        count += dfs(root.right, newMax);


        return count;
    }
}
