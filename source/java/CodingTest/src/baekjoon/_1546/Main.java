package baekjoon._1546;

import java.util.Scanner;

public class Main {

	private static int M, N;
	private static int[] a;

	public static void main(String[] args) {
		input();
		solve();
	}

	private static void solve() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += a[i];
		}
		double result = (double)sum / M * 100.0 / N;
		System.out.println(result);
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			if (M < a[i]) {
				M = a[i];
			}
		}
	}
}
