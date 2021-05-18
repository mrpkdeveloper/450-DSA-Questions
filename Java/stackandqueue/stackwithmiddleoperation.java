package stackandqueue;

public class stackwithmiddleoperation {

	public class Node {
		int data;
		Node next, prev;

		Node(int x) {
			this.data = x;
			this.next = null;
			this.prev = null;
		}
	}

	private Node head = null;
	private Node top = null;
	private Node mid = null;
	private int size = 0;

	public void push(int x) {
		if (this.size == 0) {
			this.head = new Node(x);
			this.top = head;
			this.mid = head;
		} else {
			Node nn = new Node(x);
			this.top.next = nn;
			nn.prev = this.top;
			this.top = nn;
		}
		this.size++;
		if (this.size != 1 && this.size % 2 != 0) {
			this.mid = this.mid.next;
		}
	}

	public int pop() {
		int rv = this.top.data;
		this.top = this.top.prev;
		this.size--;
		if (this.size % 2 == 0) {
			this.mid = this.mid.prev;
		}

		return rv;
	}

	public int getmid() {
		return this.mid.data;
	}

	public void deletemid() {
		if (this.size == 1) {
			this.head = null;
			this.top = head;
			this.mid = head;
		} else if (this.size == 2) {
			this.top.prev = null;
			this.head = top;
			this.mid = head;
		} else {
			Node pr = this.mid.prev;
			Node nxt = this.mid.next;
			pr.next = nxt;
			nxt.prev = pr;
			this.mid = pr;
		}
		this.size--;

	}

	public void display() {
		Node temp = this.top;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.prev;
		}
		System.out.println();
	}

	public int size() {
		return this.size;
	}
}
