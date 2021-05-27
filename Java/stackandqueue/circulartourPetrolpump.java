package stackandqueue;

public class circulartourPetrolpump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// most optimised solution
	// reffer - > https://youtu.be/MP63Tjlpcd8
	// O(N) -> space and time
	int tour(int petrol[], int distance[]) {
		int tank = 0, total = 0, idx = 0;
		for (int i = 0; i < petrol.length; i++) {
			int consume = petrol[i] - distance[i];
			tank += consume;
			if (tank < 0) {
				idx = i + 1;
				tank = 0;
			}
			// this is total fuel used in the trip
			total += consume;
		}

//		if(total fuel used <0 that means u cannot go on a trip )
		return total < 0 ? -1 : idx;
	}

}
