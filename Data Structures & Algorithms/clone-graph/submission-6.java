/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> oldToNew = new HashMap();
        Queue<Node> queue = new ArrayDeque();

        oldToNew.put(node, new Node(node.val));
        queue.add(node);

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            for (Node n: current.neighbors) {
                if (!oldToNew.containsKey(n)) {
                    // add it to hashtable
                    oldToNew.put(n, new Node(n.val));
                    // put in the map
                    queue.add(n);
                }

                oldToNew.get(current).neighbors.add(oldToNew.get(n));
            }
        }

        return oldToNew.get(node);
    }
}