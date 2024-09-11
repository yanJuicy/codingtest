import java.util.Scanner;

public class Main {
	
	private static int n, m;
	private static int[] a;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		input();
		solve();
	}

	private static void solve() {
		rec(1);
		System.out.println(sb.toString());
	}

	private static void rec(int count) {
		if (count == m + 1) {
			for (int i = 1; i<=m; i++) {
				sb.append(a[i]).append(' ');
			}
			sb.append('\n');
		} else {
			for (int i = 1; i<=n; i++) {
				a[count] = i;
				rec(count + 1);
				a[count] = 0;
			}
		}
		
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[m + 1];
		sc.close();
	}

}
