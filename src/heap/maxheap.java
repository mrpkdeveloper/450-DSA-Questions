package heap;

import java.util.ArrayList;

public class maxheap {

	ArrayList<Integer> heap = new ArrayList<Integer>();

	public void add(int item) {
		heap.add(item);
		upheapify(heap.size() - 1);
	}

	public void upheapify(int ci) {
		int pi = (ci - 1) / 2;
		if (heap.get(ci) > heap.get(pi)) {
			swap(pi, ci);
			upheapify(pi);
		}
	}

	public void swap(int pi, int ci) {
		int temp = heap.get(pi);
		heap.set(pi, heap.get(ci));
		heap.set(ci, temp);
	}

	public void remove() {
		int li = heap.size() - 1;
		swap(0, li);
		System.out.println(heap.remove(li));
		downheapify(0);
	}

	public void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int maxi = pi;
		if (lci < heap.size() && heap.get(lci) > heap.get(maxi)) {
			maxi = lci;
		}
		if (rci < heap.size() && heap.get(rci) > heap.get(maxi)) {
			maxi = rci;
		}

		if (maxi != pi) {
			swap(pi, maxi);
			downheapify(maxi);
		}

	}

	public void downheapifymod(int pi, int end) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int maxi = pi;
		if (lci < end && heap.get(lci) > heap.get(maxi)) {
			maxi = lci;
		}
		if (rci < end && heap.get(rci) > heap.get(maxi)) {
			maxi = rci;
		}

		if (maxi != pi) {
			swap(pi, maxi);
			downheapifymod(maxi, end);
		}

	}

	public void display() {
		System.out.println(heap);
	}

}
