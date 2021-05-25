package searchingandsorting;

public class majorityelement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// moores voting algorithm
	// O(n)-> time O(1)->space
	static int majorityElement(int arr[], int size) {
		int majority = -1;
		int freq = 0;
		for (int i = 0; i < arr.length; i++) {
			if (freq == 0) {
				freq = 1;
				majority = arr[i];
			} else if (arr[i] == majority) {
				freq++;
			} else {
				freq--;
			}
		}
		int ffreq = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == majority) {
				ffreq++;
			}

			if (ffreq > arr.length / 2) {
				return majority;
			}
		}

		return -1;
	}

}
