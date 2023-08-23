package baekjoon._2098;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static final int INF = 1000000 * 16 + 1;
	private static int n;
	private static int[][] w, dp;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	private static void solve() {
		System.out.println(tsp(0, 1));
	}

	private static int tsp(int c, int v) {
		if (v == (1 << n) - 1) {
			return w[c][0] == 0 ? INF : w[c][0];
		}
		if (dp[c][v] != 0) {
			return dp[c][v];
		}

		int minVal = INF;
		for (int i = 0; i < n; i++) {
			if (w[c][i] != 0 && (v & (1 << i)) == 0) {
				minVal = Math.min(minVal, tsp(i, (v | (1 << i))) + w[c][i]);
			}
		}

		return dp[c][v] = minVal;
	}

	private static void input() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bufferedReader.readLine());
		w = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] split = bufferedReader.readLine().split(" ");
			for (int j = 0; j < split.length; j++) {
				w[i][j] = Integer.parseInt(split[j]);
			}
		}
		dp = new int[n][1 << n];
	}

}
