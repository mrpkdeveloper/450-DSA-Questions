package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class medianinastream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		while (n > 0) {
			int a = scn.nextInt();
			insertHeap(a);
			System.out.println(getMedian());
			n--;
		}
		scn.close();

	}

	public static PriorityQueue<Integer> leftmaxheap = new PriorityQueue<>(Collections.reverseOrder());
	public static PriorityQueue<Integer> rightminheap = new PriorityQueue<>();

	public static void insertHeap(int x) {
		// add your code here
		if (rightminheap.size() > 0 && x > rightminheap.peek()) {
			rightminheap.add(x);
		} else {
			leftmaxheap.add(x);
		}
		balanceHeaps();
	}

	// Function to balance heaps.
	public static void balanceHeaps() {
		if (leftmaxheap.size() - rightminheap.size() == 2) {
			rightminheap.add(leftmaxheap.remove());
		} else if (rightminheap.size() - leftmaxheap.size() == 2) {
			leftmaxheap.add(rightminheap.remove());
		}
	}

	// Function to return Median.
	public static double getMedian() {
		if (leftmaxheap.size() > rightminheap.size()) {
			return leftmaxheap.peek();
		} else if (leftmaxheap.size() < rightminheap.size()) {
			return rightminheap.peek();
		} else {
			int a = leftmaxheap.peek();
			int b = rightminheap.peek();
			double ans = (double) (a + b) / 2;
			return ans;
		}
	}

}
