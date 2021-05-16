package stackandqueue;

public class stackclient {

	public static void main(String[] args) throws Exception {

		stackusingarray st = new stackusingarray(5);
		st.push(5);
		st.push(4);
		st.push(3);
		st.push(2);
		st.display();
		System.out.println(st.pop());
		System.out.println(st.top());

	}

}
