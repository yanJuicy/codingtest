package baekjoon._1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int n, m;
	private static char[][] arr;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	private static void solve() {
		int result = n * m;
		for (int i = 0; i < n - 7; i++) {
			for (int j = 0; j < m - 7; j++) {
				result = Math.min(result, Math.min(check(i, j, 'B'), check(i, j, 'W')));
			}
		}
		System.out.println(result);
	}

	private static int check(int i, int j, char bw) {
		int cnt = 0;
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if ((y + x) % 2 == 1) {
					if (arr[i + y][j + x] == bw) {
						cnt++;
					}
				} else {
					if (arr[i + y][j + x] != bw) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	private static void input() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] split = bufferedReader.readLine().split(" ");
		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);
		arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			split = bufferedReader.readLine().split("");
			for (int j = 0; j < m; j++) {
				arr[i][j] = split[j].charAt(0);
			}
		}
	}

}
