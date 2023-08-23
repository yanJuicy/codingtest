package baekjoon._1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int[][] dp;
	private static int n, m;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	private static void solve() {
		int max = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (dp[i][j] == 1) {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}
				if (max < dp[i][j]) {
					max = dp[i][j];
				}
			}
		}
		System.out.println(max * max);
	}

	private static void input() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = bufferedReader.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);
		dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			inputs = bufferedReader.readLine().split("");
			for (int j = 1; j <= m; j++) {
				dp[i][j] = Integer.parseInt(inputs[j - 1]);
			}
		}
	}
}
