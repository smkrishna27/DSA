package roku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
    }
   static Map<Node,Node> map = new HashMap<>();
    public static void main(String[] args) {
        // Build the example graph:
        // 1 -- 2
        // |    |
        // 4 -- 3

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        System.out.println(clonGraph(node1).val);

    }

    public static Node clonGraph(Node node){

        if (node == null) return null;

        if(map.containsKey(node)){
            return map.get(node);
        }
        Node clone = new Node(node.val);
        map.put(node,clone);
        for(Node neighbor : node.neighbors){
           clone.neighbors.add(clonGraph(neighbor));
        }

        return clone;

    }
}
