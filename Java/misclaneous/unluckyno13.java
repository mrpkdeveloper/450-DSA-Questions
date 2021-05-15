package misclaneous;

public class unluckyno13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		un(14);

	}

	public static void un(int n) {

		int[] arr = new int[n + 1];
		arr[1] = 1;
		arr[2] = 3;
		int k = 3;
		int start = 1;
		while (k < arr.length) {
			int size = k;
			for (int j = start; j < size && k < arr.length; j++) {
				String s = "1" + arr[j];
				arr[k] = Integer.parseInt(s);
				k++;
			}
			for (int j = start; j < size && k < arr.length; j++) {
				String s = "3" + arr[j];
				arr[k] = Integer.parseInt(s);
				k++;
			}
			start = size;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}
