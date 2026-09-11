package medium.trees;

import leetcode75.TreeNode;

public class BalancedBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right =new TreeNode(3);
        root.right.left =new TreeNode(4);
       // root.right.left.left =new TreeNode(5);
        //1,2,3,null,null,4

        System.out.println(isValidBalancedBinaryTree(root));

    }

    public static boolean isValidBalancedBinaryTree(TreeNode root) {

        return dfsHeight(root) != -1;
    }

    private static int dfsHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = dfsHeight(node.left);
        if (leftHeight == -1) return -1; // left subtree unbalanced

        int rightHeight = dfsHeight(node.right);
        if (rightHeight == -1) return -1; // right subtree unbalanced

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // current node unbalanced

        return Math.max(leftHeight, rightHeight) + 1; // return height
    }
}
