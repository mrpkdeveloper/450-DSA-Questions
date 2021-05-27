package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class interleave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		q.add(11);
		q.add(12);
		q.add(13);
		q.add(14);
		q.add(15);
		q.add(16);
		q.add(17);
		q.add(18);
		q.add(19);
		q.add(20);
		mix(q);

	}

	public static void mix(Queue<Integer> q) {

		Stack<Integer> st = new Stack<>();
		int mid = q.size() / 2;

		// push k elements to stack
		for (int i = 0; i < mid; i++) {
			st.push(q.remove());
		}

		// push back kelements to queue
		while (!st.isEmpty()) {
			q.add(st.pop());
		}

		// remove and add k elemmts in array
		for (int i = 0; i < mid; i++) {
			int rv = q.remove();
			q.add(rv);
		}

		// push k elements in stack again
		for (int i = 0; i < mid; i++) {
			st.push(q.remove());
		}

		// till now u got both half queues in stack and queue
		while (!st.isEmpty()) {
			System.out.print(st.pop() + " ");
			System.out.print(q.remove() + " ");
		}

	}

}
