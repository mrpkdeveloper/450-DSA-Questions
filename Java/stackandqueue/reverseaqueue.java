package stackandqueue;

import java.util.Queue;

public class reverseaqueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

	public static Queue<Integer> reverse(Queue<Integer> q) {
		if (q.size() == 1) {
			return q;
		}
		int top = q.remove();
		Queue<Integer> ans = reverse(q);
		ans.add(top);
		return ans;
	}

}
