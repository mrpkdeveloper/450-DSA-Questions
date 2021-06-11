package greedy;

import java.util.Scanner;

public class diehard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			int h = scn.nextInt();
			int a = scn.nextInt();
			solve(h, a);
			t--;
		}
	}

	public static void solve(int h, int a) {
		int i = 0;
		while (true) {
			if (h <= 0 || a <= 0) {
				break;
			}
			if (i % 2 == 0) {
				h += 3;
				a += 2;
			} else {
				// choose water
				if (h - 5 > 0 && a - 10 > 0) {
					h = h - 5;
					a = a - 10;
				}
				// choose fire
				else if (h - 20 > 0 && a + 5 > 0) {
					h = h - 20;
					a = a + 5;
				} else {
					break;
				}
			}
			i++;
		}
		System.out.println(i);
	}

}
