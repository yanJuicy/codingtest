import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int N, M;
	private static int i, j;
	private static int[] a, s;
	private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		input();
		for (int x = 0; x < M; x++) {
			String[] inputs = bufferedReader.readLine().split(" ");
			i = Integer.parseInt(inputs[0]) - 1;
			j = Integer.parseInt(inputs[1]) - 1;
			solve();
		}
	}

	private static void solve() {
		System.out.println(s[j] - s[i] + a[i]);
	}

	private static void input() throws IOException {
		String[] inputs = bufferedReader.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		a = new int[N];
		s = new int[N];

		inputs = bufferedReader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(inputs[i]);
		}

		s[0] = a[0];
		for (int i = 1; i < N; i++) {
			s[i] = s[i - 1] + a[i];
		}
	}
}
