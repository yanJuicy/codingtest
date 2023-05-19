package baekjoon._1328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int n, l, r;
	private static long dp[][][];

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	private static void solve() {
		dp[1][1][1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= l; j++) {
				for (int k = 1; k <= r; k++) {
					dp[i][j][k] = (dp[i - 1][j][k] * (i - 2) + dp[i - 1][j][k - 1] + dp[i - 1][j - 1][k]) % 1000000007;
				}
			}
		}

		System.out.println(dp[n][l][r]);
	}

	private static void input() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = bufferedReader.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		l = Integer.parseInt(inputs[1]);
		r = Integer.parseInt(inputs[2]);
		dp = new long[n + 1][l + 1][r + 1];
	}
}
