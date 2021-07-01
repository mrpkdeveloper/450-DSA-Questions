package dp;

public class maxlengthchain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class pair implements Comparable<pair> {
		int a, b;

		pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(pair o) {
			return this.b - o.b;
		}
	}
	
	

}
