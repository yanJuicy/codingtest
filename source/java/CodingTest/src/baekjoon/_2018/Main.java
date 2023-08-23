package baekjoon._2018;

import java.util.Scanner;

public class Main {

	private static int N;

	public static void main(String[] args) {
		input();
		solve();
	}

	private static void solve() {
		int start = 1;
		int end = 1;

		int sum = 1;
		int cnt = 0;
		while (start <= N) {
			if (sum == N) {
				cnt++;
				end++;
				sum += end;
			}
			else if (sum > N) {
				sum -= start;
				start++;
			} else {
				end++;
				sum += end;
			}

		}

		System.out.println(cnt);
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();
	}

}
