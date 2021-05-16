package stackandqueue;

public class stackusingarray {

	protected int[] data;
	protected int top;

	public static final int defaultcap = 1000;

	stackusingarray() throws Exception {
		this(defaultcap);
	}

	stackusingarray(int cap) throws Exception {

		if (cap < 1) {
			throw new Exception("invalid capacity");
		}

		this.data = new int[cap];
		this.top = -1;
	}

	public int size() {
		return this.top + 1;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void push(int val) throws Exception {
		if (this.size() == this.data.length) {
			throw new Exception(" Stack Overflow");
		}

		this.top++;
		data[this.top] = val;
	}

	public int pop() throws Exception {
		if (this.size() == 0) {
			throw new Exception(" Stack Underflow");
		}

		int rv = this.data[this.top];
		this.data[this.top] = 0;
		this.top--;
		return rv;
	}

	public int top() throws Exception {
		if (this.size() == 0) {
			throw new Exception(" Stack Underflow");
		}

		return this.data[this.top];
	}

	public void display() {

		for (int i = this.top; i >= 0; i--) {
			System.out.print(this.data[i] + " ");
		}
		System.out.println();
	}

}
