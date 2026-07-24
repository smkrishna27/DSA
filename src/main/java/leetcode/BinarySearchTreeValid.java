package leetcode;

import java.util.ArrayList;

public class BinarySearchTreeValid {
    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);
        return results;
    }
    public boolean isValidBST(){

        ArrayList<Integer> nodeValues = DFSInOrder();
        for (int i = 1; i < nodeValues.size(); i++) {
            if (nodeValues.get(i) <= nodeValues.get(i - 1)) {
                return false;
            }
        }
        return true;


    }

    public static void main(String[] args) {
        testSingleNodeTree();
        testValidBST();
        testValidBSTWithDeepLeftSubtree();
        testValidBSTWithDeepRightSubtree();
        testBalancedBST();
    }

    private static void testSingleNodeTree() {
        System.out.println("\n----- Test: Single Node Tree -----\n");
        BinarySearchTreeValid bst = new BinarySearchTreeValid();
        bst.insert(10);
        printIsValidBST(bst);
    }

    private static void testValidBST() {
        System.out.println("\n----- Test: Valid BST -----\n");
        BinarySearchTreeValid bst = new BinarySearchTreeValid();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        printIsValidBST(bst);
    }

    private static void testValidBSTWithDeepLeftSubtree() {
        System.out.println("\n----- Test: BST With Deep Left Subtree -----\n");
        BinarySearchTreeValid bst = new BinarySearchTreeValid();
        bst.insert(10);
        bst.insert(8);
        bst.insert(6);
        bst.insert(4);
        bst.insert(2);
        printIsValidBST(bst);
    }

    private static void testValidBSTWithDeepRightSubtree() {
        System.out.println("\n----- Test: BST With Deep Right Subtree -----\n");
        BinarySearchTreeValid bst = new BinarySearchTreeValid();
        bst.insert(10);
        bst.insert(12);
        bst.insert(14);
        bst.insert(16);
        bst.insert(18);
        printIsValidBST(bst);
    }

    private static void testBalancedBST() {
        System.out.println("\n----- Test: Balanced BST -----\n");
        BinarySearchTreeValid bst = new BinarySearchTreeValid();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(2);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);
        printIsValidBST(bst);
    }

    private static void printIsValidBST(BinarySearchTreeValid bst) {
        System.out.println("Is valid BST: " + bst.isValidBST());
    }


    //   +===================================================+
    //   |                  WRITE YOUR CODE HERE             |
    //   | Description:                                      |
    //   | - Checks if the binary tree is a valid Binary     |
    //   |   Search Tree (BST).                              |
    //   | - A BST is valid if all nodes follow the left <   |
    //   |   parent < right rule across the entire tree.     |
    //   | - Utilizes in-order traversal to collect node     |
    //   |   values and then checks if the list of values    |
    //   |   is in ascending order without duplicates.       |
    //   |                                                   |
    //   | Return:                                           |
    //   | - Returns true if the tree is a valid BST.        |
    //   | - Returns false otherwise.                        |
    //   |                                                   |
    //   | Tips:                                             |
    //   | - DFSInOrder() is assumed to be a method that     |
    //   |   performs an in-order traversal of the tree and  |
    //   |   returns an ArrayList of node values.            |
    //   | - A valid BST should have its in-order traversal  |
    //   |   result in a strictly ascending order list.      |
    //   +===================================================+
}
