package baekjoon._15988;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int mod = 1_000_000_009;
		int maxInput = 1000000;

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] dp = new int[maxInput + 1];
		dp[1] = 1 % mod;
		dp[2] = 2 % mod;
		dp[3] = 4 % mod;
		for (int i = 4; i <= maxInput; i++) {
			long tmp = (long) dp[i - 1] + dp[i - 2] + dp[i - 3];
			dp[i] = (int) (tmp % mod);
		}

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
	}
}