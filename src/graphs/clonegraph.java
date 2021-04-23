package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class clonegraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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

	HashMap<Node, Node> map = new HashMap<>();

	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}
		map.put(node, new Node(node.val, new ArrayList<>()));

		for (Node neighbor : node.neighbors) {
			if (map.containsKey(neighbor)) {
				Node copy = map.get(node);
				copy.neighbors.add(map.get(neighbor));
			} else {
				Node copy = map.get(node);
				copy.neighbors.add(cloneGraph(neighbor));
			}
		}

		return map.get(node);
	}

}
