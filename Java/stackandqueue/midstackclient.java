package stackandqueue;

public class midstackclient {

	public static void main(String[] args) {
		stackwithmiddleoperation st = new stackwithmiddleoperation();
		st.push(5);
		st.push(4);
//		st.push(3);
//		st.push(2);
//		st.push(1);
		st.display();
		System.out.println(st.getmid());
		System.out.println(st.size());
//		st.deletemid();
//		st.display();

	}

}
