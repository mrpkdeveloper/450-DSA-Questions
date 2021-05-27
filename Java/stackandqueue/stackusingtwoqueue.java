package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class stackusingtwoqueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	// push efficient
	// Function to push an element into stack using two queues.
	void push(int a) {
		q1.add(a);
	}

	// Function to pop an element from stack using two queues.
	int pop() {
		if (q1.isEmpty()) {
			return -1;
		}

		while (q1.size() != 1) {
			q2.add(q1.remove());
		}

		int ans = q1.remove();
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		return ans;
	}

	// pop efficient
	// Function to push an element into stack using two queues.
	void push1(int a) {
		q2.add(a);
		while (!q1.isEmpty()) {
			q2.add(q1.remove());
		}
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}

	// Function to pop an element from stack using two queues.
	int pop1() {
		if (q1.isEmpty()) {
			return -1;
		}

		return q1.remove();
	}

}
