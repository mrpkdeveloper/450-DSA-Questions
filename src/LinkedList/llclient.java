package LinkedList;

public class llclient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(30);
		list.addLast(20);
		list.display();
		list.addFirst(5);
		list.addFirst(8);
		list.display();
		System.out.println(list.getfirst());
		System.out.println(list.getlast());
		System.out.println(list.getAt(2));
		list.addAt(15, 3);
		list.display();
		System.out.println(list.getMid());
		System.out.println();
		System.out.println(list.removeFirst());
		list.display();
		System.out.println(list.removeLast());
		list.display();
		System.out.println(list.removeAt(2));
		list.display();
		list.reverseData();
		list.display();
		list.reversePointers();
		list.display();
		System.out.println(list.getMid());
	}

}
