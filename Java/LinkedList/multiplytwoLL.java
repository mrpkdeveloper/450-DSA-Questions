package LinkedList;

public class multiplytwoLL {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// easy method
	public static long multiplyTwoLists(Node first, Node second) {

		long num1 = 0, num2 = 0;
		int mod = 1000000007;

		// Generate numbers from linked lists
		while (first != null || second != null) {
			if (first != null) {
				num1 = ((num1 * 10) % mod + first.data) % mod;
				first = first.next;
			}
			if (second != null) {
				num2 = ((num2 * 10) % mod + second.data) % mod;
				second = second.next;
			}
		}

		// Return multiplication of
		// two numbers
		return (num1 % mod) * (num2 % mod) % mod;
	}

	// multiply ll and return ll
	public Node multiplyTwoListsog(Node l1, Node l2) {
		// add code here.
		Node temp1 = reverse(l1);
		Node temp2 = reverse(l2);

		Node t2 = temp2;
		Node ans = new Node(-1);
		Node tempans = ans;
		while (t2 != null) {
			Node prod = multiply(temp1, t2.data);
			t2 = t2.next;

			addLL(prod, tempans);
			tempans = tempans.next;
		}

		return reverse(ans.next);
	}

	static void addLL(Node prod, Node tempans) {

		Node ta = tempans;
		Node tp = prod;
		int c = 0;
		while (c != 0 || tp != null) {
			int sum = c + (ta != null ? ta.data : 0) + (tp != null ? tp.data : 0);
			int digit = sum % 10;
			c = sum / 10;
			if (ta.next != null) {
				ta.next.data = digit;
			} else {
				ta.next = new Node(digit);
			}
			if (tp != null) {
				tp = tp.next;
			}
			ta = ta.next;
		}
	}

	public static Node multiply(Node head, int d) {
		Node ans = new Node(-1);
		Node temp = head;
		Node tempans = ans;
		int carry = 0;
		while (temp != null || carry != 0) {
			int mult = (temp != null ? temp.data : 0) * d + carry;
			Node nn = new Node(mult % 10);
			carry = mult / 10;
			tempans.next = nn;
			tempans = tempans.next;
			if (temp != null)
				temp = temp.next;
		}
		return ans.next;
	}

	public static Node reverse(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node prev = head;
		Node curr = head.next;
		while (curr != null) {
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		head.next = null;
		return prev;
	}

}
