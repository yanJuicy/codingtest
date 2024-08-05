import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    private static int n;
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int sum = 0;
        while (pq.size() != 1) {
            int a = pq.poll();
            int b = pq.poll();
            sum += a + b;
            pq.add(a + b);
        }

        System.out.println(sum);
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(bufferedReader.readLine()));
        }
    }

}
