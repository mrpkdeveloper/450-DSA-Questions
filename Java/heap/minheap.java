package heap;

import java.util.ArrayList;

public class minheap {

	ArrayList<Integer> heap = new ArrayList<Integer>();

	public void add(int item) {
		heap.add(item);
		upheapify(heap.size() - 1);
	}

	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;
		if (heap.get(ci) < heap.get(pi)) {
			swap(pi, ci);
			upheapify(pi);
		}
	}

	private void swap(int pi, int ci) {
		int temp = heap.get(pi);
		heap.set(pi, heap.get(ci));
		heap.set(ci, temp);
	}

	public int remove() {
		int li = heap.size() - 1;
		swap(0, li);
		int ans = heap.remove(li);
		downheapify(0);
		return ans;
	}

	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;
		if (lci < heap.size() && heap.get(lci) < heap.get(mini)) {
			mini = lci;
		}
		if (rci < heap.size() && heap.get(rci) < heap.get(mini)) {
			mini = rci;
		}

		if (mini != pi) {
			swap(pi, mini);
			downheapify(mini);
		}

	}

	public void display() {
		System.out.println(heap);
	}

}
