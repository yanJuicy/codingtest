package baekjoon._3040;

import java.util.Scanner;

public class Main {

	private static int[] a;
	private static boolean[] visit;

	public static void main(String[] args) {
		input();
		solve();
	}

	private static void solve() {
		combination(0, 9, 7, 0);
	}

	private static void combination(int start, int n, int r, int sum) {
		if (r == 0) {
			if (sum == 100) {
				for (int i = 0; i < n; i++) {
					if (visit[i]) {
						System.out.println(a[i]);
					}
				}
			}
		} else {
			for (int i = start; i < n; i++) {
				visit[i] = true;
				sum += a[i];
				combination(i + 1, n, r - 1, sum);
				sum -= a[i];
				visit[i] = false;
			}
		}
	}

	private static void input() {
		a = new int[9];
		visit = new boolean[9];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			a[i] = sc.nextInt();
		}
	}

}
