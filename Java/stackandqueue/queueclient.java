package stackandqueue;

public class queueclient {

	public static void main(String[] args) {
		queue q = new queue(5);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.dequeue();
		q.enqueue(6);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.display();

	}

}
