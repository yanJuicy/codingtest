package baekjoon._2342;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int mp[][] = {
			{0, 2, 2, 2, 2},
			{2, 1, 3, 4, 3},
			{2, 3, 1, 3, 4},
			{2, 4, 3, 1, 3},
			{2, 3, 4, 3, 1}
	};
	private static int order[];
	private static int dp[][][];

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	private static void solve() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < order.length + 1; k++) {
					dp[k][i][j] = 100001 * 4;
				}
			}
		}
		dp[0][0][0] = 0;

		int s = 1;
		for (int n : order) {
			if (n == 0) {
				break;
			}

			for (int i = 0; i < 5; i++) {
				if (n == i) {
					continue;
				}
				for (int j = 0; j < 5; j++) {
					dp[s][i][n] = Math.min(dp[s - 1][i][j] + mp[j][n], dp[s][i][n]);
				}
			}

			for (int j = 0; j < 5; j++) {
				if (n == j) {
					continue;
				}
				for (int i = 0; i < 5; i++) {
					dp[s][n][j] = Math.min(dp[s - 1][i][j] + mp[i][n], dp[s][n][j]);
				}
			}
			s++;
		}
		s--;

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				min = Math.min(min, dp[s][i][j]);
			}
		}
		System.out.println(min);
	}

	private static void input() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = bufferedReader.readLine().split(" ");
		order = new int[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			order[i] = Integer.parseInt(inputs[i]);
		}
		dp = new int[inputs.length + 1][5][5];
	}
}
