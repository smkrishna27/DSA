package Agoda;

import leetcode.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BSTDistance {

   static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }
    }
    public static int distance(Node root,int v1,int v2){
        if(root==null){
         return 0;
        }
        Node cur = findLCA(root,v1,v2);
        return findDistanceFromRoot(cur,v1)+findDistanceFromRoot(cur,v2);
    }

    private static int findDistanceFromRoot(Node root, int target) {
        int dist = 0;
        while (root != null && root.val != target) {
            if (target < root.val) root = root.left;
            else root = root.right;
            dist++;
        }
        return dist;
    }

    static Node findLCA(Node root,int v1,int v2){
        if(root==null){
            return null;
        }
        if(root.val == v1 || root.val == v2){
            return root;
        }
        if( v1< root.val &&  v2< root.val ){
           root = root.left;
        } else if(v1>root.val && v2>root.val ){
           root = root.right;
        }
        return root;
    }
    public static List<Integer> print(Node root){

        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.val);
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }

            }
        }

        new Traverse(root);
        return results;

    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(3);
        node.left.left = new Node(2);
        node.left.right = new Node(4);
        node.right = new Node(8);
        node.right.right = new Node(10);
        System.out.println(print(node));

        System.out.println(distance(node,2,10));


    }
}
