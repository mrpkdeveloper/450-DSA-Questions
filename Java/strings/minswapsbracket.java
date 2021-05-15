package strings;

public class minswapsbracket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		minswap("]][[");
//		minswapoptimised("]][[");
		minswapoptimised("[]][][");

	}

	// O(n)->time
	// O(n)->space
	public static void minswap(String s) {
		int open = 0, k = 0, minswap = 0;
		char[] sarr = s.toCharArray();
		int[] openarr = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (sarr[i] == '[') {
				openarr[k++] = i;
			}
		}
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			if (sarr[i] == '[') {
				open++;
				j++;
			} else if (sarr[i] == ']') {
				open--;
			}
			if (open < 0) {
				minswap += openarr[j] - i;
				char temp = sarr[i];
				sarr[i] = sarr[openarr[j]];
				sarr[openarr[j]] = temp;
				open = 1;
				j++;
			}
		}
		System.out.println(minswap);
	}

	// O(n)->time
	// O(1)->space
	public static void minswapoptimised(String s) {
		int open = 0, k = 0, minswap = 0, fault = 0, close = 0;
		char[] sarr = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (sarr[i] == ']') {
				close++;
				fault = close - open;
			} else {
				open++;
				if (fault > 0) {
					minswap += fault;
					fault--;
				}

			}
		}
		System.out.println(minswap);
	}

}
