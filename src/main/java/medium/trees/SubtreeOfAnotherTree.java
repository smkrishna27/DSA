package medium.trees;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {

    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        String rootString = serialize(root);
        String subString = serialize(subRoot);

        return rootString.contains(subString);

    }

    private static String serialize(TreeNode node) {
        if (node == null)
            return "#";

        return "^" + node.val + serialize(node.left) + serialize(node.right);
    }
}
