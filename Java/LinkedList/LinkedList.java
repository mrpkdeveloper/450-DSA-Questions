package LinkedList;

public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head = null;
	private Node tail = null;
	private int size = 0;

	public void display() {
		Node temp = this.head;
		System.out.println("----------------------");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("----------------------");
	}

	public void addLast(int x) {
		Node node = new Node();
		node.data = x;
		node.next = null;
		if (this.head == null) {
			this.head = node;
		} else {
			this.tail.next = node;
		}
		this.tail = node;
		this.size++;
	}

	public void addFirst(int x) {
		Node node = new Node();
		node.data = x;
		if (this.head == null) {
			this.head = node;
			this.tail = node;
			node.next = null;
		} else {
			node.next = this.head;
			this.head = node;
		}

		this.size++;
	}

	public int getfirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}
		return this.head.data;
	}

	public int getlast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}
		return this.tail.data;
	}

	public int getAt(int i) throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}
		if (i < 0 || i >= size) {
			throw new Exception("invalid index");
		}

		Node temp = head;
		while (i > 0) {
			temp = temp.next;
			i--;
		}
		return temp.data;

	}

	private Node getNodeAt(int i) throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}
		if (i < 0 || i >= size) {
			throw new Exception("invalid index");
		}

		Node temp = head;
		while (i > 0) {
			temp = temp.next;
			i--;
		}
		return temp;

	}

	public void addAt(int x, int i) throws Exception {
		if (i < 0 || i > size) {
			throw new Exception("invalid index");
		}
		if (i == 0) {
			addFirst(x);
		} else if (i == this.size) {
			addLast(x);
		} else {
			Node n = getNodeAt(i - 1);
			Node node = new Node();
			node.data = x;
			node.next = n.next;
			n.next = node;
			this.size++;
		}
	}

	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}

		int rv = this.head.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = head.next;
		}

		this.size--;
		return rv;
	}

	public int removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked List is empty");
		}

		int rv = this.tail.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.tail = getNodeAt(this.size - 2);
			this.tail.next = null;
		}

		this.size--;
		return rv;
	}

	public int removeAt(int i) throws Exception {
		if (i < 0 || i > size) {
			throw new Exception("invalid index");
		}
		int rv = 0;
		if (i == 0) {
			rv = removeFirst();
		} else if (i == this.size) {
			rv = removeLast();
		} else {
			Node n = getNodeAt(i - 1);
			rv = n.next.data;
			n.next = n.next.next;
			this.size--;
		}
		return rv;
	}

	public void reverseData() {
		int[] data = new int[this.size];
		Node temp = this.head;
		int i = 0;
		while (temp != null) {
			data[i] = temp.data;
			i++;
			temp = temp.next;
		}

		int j = this.size - 1;
		temp = this.head;
		while (temp != null) {
			temp.data = data[j];
			j--;
			temp = temp.next;
		}

	}

	public void reversePointers() {

		Node prev = this.head;
		Node curr = prev.next;

		while (curr != null) {
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}

		Node t = this.head;
		this.head = this.tail;
		this.tail = t;
		this.tail.next = null;

	}

	// without using size (IMP LOGIC)
	public int getMid() {

		Node temp = this.head;
		Node temp2 = this.head;

		while (temp2.next != null && temp2.next.next != null) {
			temp = temp.next;
			temp2 = temp2.next.next;
		}
		return temp.data;

	}

}
