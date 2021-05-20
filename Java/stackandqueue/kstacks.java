  package stackandqueue;

public class kstacks {

	private int[] data; // actual array for storing data
	private int[] next; // stores next free idx
	private int[] top; // stores idx of top element of stacks

	// n-> total array size , k -> no of stacks
	private int n, k;
	private int free; // stores curr free idx

	kstacks(int n, int k) {
		this.n = n;
		this.k = k;
		this.data = new int[this.n];
		this.next = new int[this.n];
		this.top = new int[this.k];

		// intialise top as -1
		for (int i = 0; i < top.length; i++) {
			this.top[i] = -1;
		}

		this.free = 0;

		// intialises all space as free
		for (int i = 0; i < next.length; i++) {
			this.next[i] = i + 1;
		}
		this.next[n - 1] = -1;

	}

	public boolean isFull() {
		return (free == -1);
	}

	public boolean isEmpty(int sn) {
		return (this.top[sn] == -1);
	}

	public void push(int x, int sn) {
		if (isFull()) {
			System.out.println("No available space");
			return;
		}

		// i is place where item will store
		int i = this.free;

		// nxt free space available
		this.free = this.next[i];

		this.next[i] = this.top[sn];
		this.top[sn] = i; // sn top is now at ith idx

		// putting value in stack
		this.data[i] = x;

	}

	public int pop(int sn) {
		if (isEmpty(sn)) {
			System.out.println("Stack Empty");
			return -1;
		}

		// i is place where item is stored
		int i = this.top[sn];

		this.top[sn] = this.next[i]; // sn top is now at next top

		// nxt free space available
		this.next[i] = free;
		this.free = i;

		// putting value in stack
		return this.data[i];

	}

	public void display(int sn) {
		if (isEmpty(sn)) {
			System.out.println("Stack empty");
			return;
		}

		int i = top[sn];
		while (i != -1) {
			System.out.print(data[i] + " ");
			i = this.next[i];
		}
		System.out.println();

	}

}
