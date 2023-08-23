package baekjoon._11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int N, M;
	private static int[][] s;
	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	private static void solve() throws IOException {
		for (int i = 0; i < M; i++) {
			String[] inputs = bufferedReader.readLine().split(" ");
			int x1 = Integer.parseInt(inputs[0]);
			int y1 = Integer.parseInt(inputs[1]);
			int x2 = Integer.parseInt(inputs[2]);
			int y2 = Integer.parseInt(inputs[3]);

			System.out.println(s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1]);
		}
	}

	private static void input() throws IOException {
		String[] inputs = bufferedReader.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		s = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			inputs = bufferedReader.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + Integer.parseInt(inputs[j - 1]);
			}
		}
	}

}
