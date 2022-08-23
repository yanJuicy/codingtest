package baekjoon._11720;

import java.util.Scanner;

public class Main {

	static int N;
	static String s;

	public static void main(String[] args) {
		input();
		solve();
	}

	private static void solve() {
		int sum = 0;
		for (char c : s.toCharArray()) {
			sum += c - '0';
		}
		System.out.println(sum);
	}

	private static void input() {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		s = scanner.next();
		scanner.close();
	}

}
