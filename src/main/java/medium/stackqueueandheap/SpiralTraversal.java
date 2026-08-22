package medium.stackqueueandheap;


import java.util.Stack;

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
