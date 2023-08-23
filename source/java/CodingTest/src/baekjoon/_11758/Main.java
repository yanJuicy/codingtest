package baekjoon._11758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int x1, x2, x3, y1, y2, y3;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	private static void solve() {
		int ccw = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
		if (ccw < 0) {
			System.out.println(-1);
		} else if (ccw == 0) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}
	}

	private static void input() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] split = bufferedReader.readLine().split(" ");
		x1 = Integer.parseInt(split[0]);
		y1 = Integer.parseInt(split[1]);
		split = bufferedReader.readLine().split(" ");
		x2 = Integer.parseInt(split[0]);
		y2 = Integer.parseInt(split[1]);
		split = bufferedReader.readLine().split(" ");
		x3 = Integer.parseInt(split[0]);
		y3 = Integer.parseInt(split[1]);
	}
}
