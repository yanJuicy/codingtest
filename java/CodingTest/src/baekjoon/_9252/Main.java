package baekjoon._9252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static String a, b;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	private static void solve() {
		int[][] dp = new int[a.length() + 1][b.length() + 1];

		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		List<Character> lcs = new ArrayList<>();
		int r = a.length();
		int c = b.length();
		while (r > 0 && c > 0) {
			if (a.charAt(r - 1) == b.charAt(c - 1)) {
				lcs.add(a.charAt(r - 1));
				r--;
				c--;
			} else {
				if (dp[r - 1][c] > dp[r][c - 1]) {
					r--;
				} else {
					c--;
				}
			}
		}

		System.out.println(dp[a.length()][b.length()]);
		for (int i = lcs.size() - 1; i >= 0; i--) {
			System.out.print(lcs.get(i));
		}
	}

	private static void input() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		a = bufferedReader.readLine();
		b = bufferedReader.readLine();
	}

}
