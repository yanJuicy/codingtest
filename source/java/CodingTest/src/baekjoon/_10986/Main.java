package baekjoon._10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int N, M;
	private static long[] s, c;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	private static void solve() {
		long result = 0;
		for (int i = 1; i <= N; i++) {
			int remainder = (int)(s[i] % M);
			if (remainder == 0) {
				result++;
			}
			c[remainder]++;
		}

		for (int i = 0; i < M; i++) {
			if (c[i] >= 2) {
				result += c[i] * (c[i] - 1) / 2;
			}
		}

		System.out.println(result);
	}

	private static void input() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] inputs = bufferedReader.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);

		s = new long[N + 1];
		c = new long[M];

		inputs = bufferedReader.readLine().split(" ");

		for (int i = 1; i <= N; i++) {
			s[i] = s[i - 1] + Integer.parseInt(inputs[i - 1]);
		}
	}

}
