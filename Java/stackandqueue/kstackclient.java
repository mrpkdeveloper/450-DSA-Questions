package stackandqueue;

public class kstackclient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		kstacks st = new kstacks(10, 3);
		st.push(1, 0);
		st.push(1, 1);
		st.push(1, 2);

		st.push(2, 0);
		st.push(2, 1);
		st.push(2, 2);

		st.display(0);
		
		st.push(3, 0);
		st.push(3, 1);
		st.push(3, 2);

		st.push(4, 2);
//		st.push(5, 2);

		System.out.println(st.pop(0));
		System.out.println(st.pop(0));
		System.out.println(st.pop(1));

		st.display(2);
		st.display(1);
		st.display(0);

	}

}
