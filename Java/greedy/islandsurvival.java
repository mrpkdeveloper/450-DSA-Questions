package greedy;

public class islandsurvival {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve(7, 6, 6);

	}

	// nod -> no of days
	// pdf -> per day food he can buy
	// frs -> food required per day for survival
	public static void solve(int nod, int pdf, int frs) {

		int noofsunday = nod / 7;
		int actualday = nod - noofsunday;
		int totalfoodrequired = nod * frs;
		int mindays = 0;
		if (totalfoodrequired % pdf == 0) {
			mindays = totalfoodrequired / pdf;
		} else {
			mindays = totalfoodrequired / pdf + 1;
		}

		if (mindays <= actualday) {
			System.out.println("yes " + mindays);
		} else {
			System.out.println("No");
		}

	}

}
