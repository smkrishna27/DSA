package medium.trees;

import leetcode75.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {


    }

    public static int maxDepthOfBinaryTree(TreeNode root) {


        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null || node.right != null) {
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
            depth++;

        }


        return depth;


    }
}
