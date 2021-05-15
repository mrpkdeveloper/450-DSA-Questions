package heap;

public class heapsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxheap heap = new maxheap();
		heap.add(12);
		heap.add(11);
		heap.add(13);
		heap.add(5);
		heap.add(6);
		heap.add(7);
		heap.display();
		heapsort(heap);
		heap.display();

	}

	public static void heapsort(maxheap heap) {
		int sz = heap.heap.size();
		while (sz > 1) {
			heap.swap(0, sz - 1);
			sz--;
			heap.downheapifymod(0, sz);
		}
	}
}
