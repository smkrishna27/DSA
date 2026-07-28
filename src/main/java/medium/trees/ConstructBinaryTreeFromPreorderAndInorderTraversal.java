package medium.trees;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    static int preIndex;
    static HashMap<Integer, Integer> inOrderMap = new HashMap<>();

    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;

        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);

        }
        preIndex = 0;
        return splitTree(preorder, 0, inorder.length - 1);


    }

    private static TreeNode splitTree(int[] preOrder, int left, int right) {

        if (left > right) {
            return null;
        }

        int rootVal = preOrder[preIndex++];
        int mid = inOrderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = splitTree(preOrder, left, mid - 1);
        root.right = splitTree(preOrder, mid + 1, right);

        return root;

    }
}
