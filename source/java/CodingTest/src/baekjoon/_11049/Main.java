package baekjoon._11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int n;
	private static Matrix[] m;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	private static void solve() {
		System.out.println(execute(1, n));
	}

	private static int execute(int s, int e) {
		int result = Integer.MAX_VALUE;
		if (dp[s][e] != -1) {
			return dp[s][e];
		}
		if (s == e) {
			return 0;
		}
		if (s + 1 == e) {
			return m[s].r * m[s].c * m[e].c;
		}
		for (int i = s; i < e; i++) {
			result = Math.min(result, m[s].r * m[i].c * m[e].c + execute(s, i) + execute(i + 1, e));
		}
		return dp[s][e] = result;
	}

	private static void input() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bufferedReader.readLine());
		m = new Matrix[n + 1];
		dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			String[] split = bufferedReader.readLine().split(" ");
			m[i] = new Matrix(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
		}
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}
	}

	private static class Matrix {
		private int r, c;

		public Matrix(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
