package medium.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {

    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        rightView(root, res, 0);

        return res;

    }

    private static void rightView(TreeNode root, List<Integer> res, int i) {
        if (root == null) return;

        if (i == res.size() ) {
            res.add(root.val);
        }
        rightView(root.left, res, i + 1);

        rightView(root.right, res, i + 1);
    }
}

