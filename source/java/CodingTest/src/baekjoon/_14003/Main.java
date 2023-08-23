package baekjoon._14003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int n;
	private static int[] a, d, answer;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	private static void solve() {
		int maxLength = 1;
		int[] b = new int[n + 1];
		int index;
		b[1] = a[1];
		d[1] = 1;

		for (int i = 2; i <= n; i++) {
			if (b[maxLength] < a[i]) {
				b[++maxLength] = a[i];
				d[i] = maxLength;
			} else {
				index = binarySearch(1, maxLength, a[i], b);
				b[index] = a[i];
				d[i] = index;
			}
		}
		System.out.println(maxLength);

		answer = new int[n + 1];
		index = maxLength;
		int x = b[maxLength] + 1;
		for (int i = n; i >= 1; i--) {
			if (d[i] == index && a[i] < x) {
				answer[index] = a[i];
				x = a[i];
				index--;
			}
		}
		for (int i = 1; i <= maxLength; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	private static int binarySearch(int l, int r, int key, int[] arr) {
		while (l < r) {
			int mid = (l + r) / 2;
			if (arr[mid] < key) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return l;
	}

	private static void input() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bufferedReader.readLine());
		a = new int[n + 1];
		d = new int[n + 1];
		String[] split = bufferedReader.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a[i + 1] = Integer.parseInt(split[i]);
		}
	}
}
