package mattrix;

import java.util.Stack;

public class maxsizerectangle {

	public static void main(String[] args) {
		int[][] m = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		maxrectanglearea(m);

	}

	public static void maxrectanglearea(int[][] m) {

		int[] arr = m[0];
		int maxarea = maxhistogramarea(arr);

		for (int i = 1; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (m[i][j] == 0) {
					arr[j] = 0;
				} else {
					arr[j]++;
				}
			}

			int area = maxhistogramarea(arr);
			if (area > maxarea) {
				maxarea = area;
			}
		}
		System.out.println(maxarea);

	}

	public static int maxhistogramarea(int[] arr) {
		Stack<Integer> stackleft = new Stack<Integer>();
		stackleft.push(0);
		int[] left = new int[arr.length];
		left[0] = -1;
		for (int i = 1; i < arr.length; i++) {
			while (stackleft.size() > 0 && arr[i] <= arr[stackleft.peek()]) {
				stackleft.pop();
			}
			if (stackleft.size() == 0) {
				left[i] = -1;
			} else {
				left[i] = stackleft.peek();
			}
			stackleft.push(i);
		}

		Stack<Integer> stackright = new Stack<Integer>();
		stackright.push(arr.length - 1);
		int[] right = new int[arr.length];
		right[right.length - 1] = right.length;
		for (int i = right.length - 2; i >= 0; i--) {
			while (stackright.size() > 0 && arr[i] <= arr[stackright.peek()]) {
				stackright.pop();
			}
			if (stackright.size() == 0) {
				right[i] = arr.length;
			} else {
				right[i] = stackright.peek();
			}
			stackright.push(i);

		}

		int maxarea = 0;
		for (int i = 0; i < right.length; i++) {
			int width = right[i] - left[i] - 1;
			int area = arr[i] * width;
			if (maxarea < area) {
				maxarea = area;
			}
		}

		return maxarea;

	}

}
