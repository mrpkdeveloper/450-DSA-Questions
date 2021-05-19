package stackandqueue;

public class queue {

	private int[] data;
	private static final int defcap = 10;
	private int size = 0;
	private int rear = 0, front = 0;

	queue() {
		this(defcap);
	}

	queue(int capacity) {
		this.data = new int[capacity];
		this.rear = capacity - 1;
	}

	public void enqueue(int val) {
		if (this.size == this.data.length) {
			System.out.println("queue is full");
			return;
		}

		this.rear = (this.rear + 1) % this.data.length;
		this.data[this.rear] = val;
		this.size++;
	}

	public int dequeue() {
		if (this.size == 0) {
			System.out.println("queue is empty");
			return -1;
		}

		int val = this.data[this.front];
		this.front = (this.front + 1) % this.data.length;
		this.size--;
		return val;

	}

	public void display() {
		int i = front;
		int c = 0;
		while (c < this.size) {
			System.out.print(this.data[i] + " ");
			i = (i + 1) % this.data.length;
			c++;
		}
		System.out.println();
	}

}
