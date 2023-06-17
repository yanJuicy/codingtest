package baekjoon._1003;

import java.util.Scanner;

public class Main {

	private static int d[][];

	public static void main(String[] args) {
		bottomUp();
		solve();
	}

	private static void solve() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int s = 0; s < t; s++) {
			int n = sc.nextInt();
			System.out.println(d[n][0] + " " + d[n][1]);
		}
	}

	private static void bottomUp() {
		d = new int[41][2];
		d[0][0] = 1;
		d[0][1] = 0;
		d[1][0] = 0;
		d[1][1] = 1;

		for (int i = 2; i <= 40; i++) {
			d[i][0] = d[i - 1][0] + d[i - 2][0];
			d[i][1] = d[i - 1][1] + d[i - 2][1];
		}
	}

}
