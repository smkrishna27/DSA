package medium.trees;


import java.util.*;

public class SpiralTraversal {


    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(3);
        root.left.right = new Node(6);
        root.left.left = new Node(8);
        spiralTraversal(root);

    }


    static void spiralTraversal(Node root) {
        if (root == null) return;

        Stack<Node> s1 = new Stack<>(); // left to right
        Stack<Node> s2 = new Stack<>(); // right to left

        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node temp = s1.pop();
                System.out.print(temp.val + " ");
                if (temp.left != null) s2.push(temp.left);
                if (temp.right != null) s2.push(temp.right);
            }
            while (!s2.isEmpty()) {
                Node temp = s2.pop();
                System.out.print(temp.val + " ");
                if (temp.right != null) s1.push(temp.right);
                if (temp.left != null) s1.push(temp.left);
            }
        }
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (leftToRight) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
            leftToRight = !leftToRight;
        }

        return result;
    }

    static class Node {
        int val;
        Node left;
        Node right;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
