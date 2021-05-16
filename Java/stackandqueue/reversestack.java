package stackandqueue;

public class reversestack {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		stackusingarray st = new stackusingarray(5);
		st.push(5);
		st.push(4);
		st.push(3);
		st.push(2);
		st.push(1);
		st.display();

//		stackusingarray helper = new stackusingarray(5);
//		reverse(st, helper, 0);
		reversewithoutextrastack(st);
		st.display();

	}

	// inplace reverse but uses extra stack
	public static void reverse(stackusingarray og, stackusingarray helper, int idx) throws Exception {
		if (og.size() == 0) {
			return;
		}
		int top = og.pop();
		reverse(og, helper, idx + 1);
		helper.push(top);
		if (idx == 0) {

			while (!helper.isEmpty()) {
				og.push(helper.pop());
			}

		}
	}

	// Optimized for space (did't used any loop) time-> O(n2)
	public static void reversewithoutextrastack(stackusingarray og) throws Exception {
		if (og.size() == 0) {
			return;
		}

		int top = og.pop();
		reversewithoutextrastack(og);
		insertbottom(og, top);

	}

	private static void insertbottom(stackusingarray og, int element) throws Exception {
		if (og.size() == 0) {
			og.push(element);
			return;
		}

		int top = og.pop();
		insertbottom(og, element);
		og.push(top);
	}

}
