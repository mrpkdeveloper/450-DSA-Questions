package array;

public class pallindromicarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pallindrome(243);

	}

	public static int pallindromicarray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if(!pallindrome(arr[i])) {
				return 0;
			}
		}
		return 1;
		
	}

	public static boolean pallindrome(int n) {
		int reverse = 0;
		int temp = n, rem = 0;
		while (temp > 0) {
			rem = temp % 10;
			temp = temp / 10;
			reverse = reverse * 10 + rem;
		}
		if(n==reverse) {
			return true;
		}
		return false;
	}

}
