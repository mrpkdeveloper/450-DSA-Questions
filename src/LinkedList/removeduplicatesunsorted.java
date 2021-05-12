package LinkedList;

import java.util.HashSet;

public class removeduplicatesunsorted {

	private class Node {
		int data;
		Node next;
	}

	public Node removeDuplicates(Node head) {
		HashSet<Integer> map = new HashSet<>();
		Node temp = head;
		map.add(temp.data);
		while (temp != null) {
			Node ahead = temp.next;
			while (ahead != null && map.contains(ahead.data)) {
				temp.next = ahead.next;
				ahead = temp.next;
			}
			temp = ahead;
			if (temp != null)
				map.add(temp.data);
		}
		return head;
	}
}
