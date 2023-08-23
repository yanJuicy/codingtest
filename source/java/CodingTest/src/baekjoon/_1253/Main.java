package baekjoon._1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int n;
	private static int[] a;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	private static void solve() {
		Arrays.sort(a);
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			int target = a[i];

			int start = 0;
			int end = n - 1;
			while (start < end) {
				if (a[start] + a[end] == target) {
					if (start != i && end != i) {
						cnt++;
						break;
					} else if (start == i) {
						start++;
					} else if (end == i) {
						end--;
					}
				} else if (a[start] + a[end] < target) {
					start++;
				} else {
					end--;
				}
			}

		}

		System.out.println(cnt);
	}

	private static void input() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bufferedReader.readLine());
		a = new int[n];

		String[] inputs = bufferedReader.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(inputs[i]);
		}
	}

}
