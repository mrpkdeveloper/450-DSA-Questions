package stackandqueue;

public class kqueue {

	private int[] data; // actual array for storing data
	private int[] next; // stores next free idx
	private int[] front; // stores idx of top element of queue
	private int[] rear; // stores idx of last element of queue

	private int free;

	kqueue(int n, int k) {

		this.data = new int[n];
		this.next = new int[n];
		this.front = new int[k];
		this.rear = new int[k];

		// intialise front and rear as -1
		for (int i = 0; i < front.length; i++) {
			this.front[i] = -1;
			this.rear[i] = -1;
		}

		this.free = 0;

		// intialises all space as free
		for (int i = 0; i < next.length; i++) {
			this.next[i] = i + 1;
		}
		this.next[n - 1] = -1;

	}

	public boolean isfull() {
		return (this.free == -1);
	}

	public boolean isEmpty(int qn) {
		return (this.front[qn] == -1);
	}

	public void add(int val, int qn) {

		if (isfull()) {
			System.out.println("queue is full");
			return;
		}

		int nextFree = next[free];

		if (isEmpty(qn)) {
			rear[qn] = front[qn] = free;
		} else {
			// Update next of rear and then rear for queue number 'j'
			next[rear[qn]] = free;
			rear[qn] = free;
		} 
		next[free] = -1;

		// Put the item in array
		data[free] = val;

		// Update index of free slot to index of next slot in free list
		free = nextFree;

	}

	public int remove(int qn) {

		if (isEmpty(qn)) {
			System.out.println("queue is empty");
			return -1;
		}

		// this idx value has to be removed
		int i = this.front[qn];

		this.front[qn] = this.next[i];
		this.next[i] = free;

		this.free = i;

		return this.data[i];

	}

	public void display(int qn) {
		if (isEmpty(qn)) {
			System.out.println("queue is empty");
			return;
		}

		int i = front[qn];
		while (i != -1) {
			System.out.print(data[i] + " ");
			i = this.next[i];
		}
		System.out.println();

	}

}
