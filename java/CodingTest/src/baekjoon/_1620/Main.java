package baekjoon._1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static int n, m;
    private static String[] problems;
    private static Map<String, String> poketmons, keys;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        for (String problem : problems) {
            if (isNumber(problem)) {
                sb.append(poketmons.get(problem)).append('\n');
            } else {
                sb.append(keys.get(problem)).append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    private static boolean isNumber(String s) {
        if (s.charAt(0) >= '0' && s.charAt(0) <= '9')
            return true;
        return false;
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(lines[0]);
        m = Integer.parseInt(lines[1]);

        poketmons = new HashMap<>();
        keys = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String poketmon = bufferedReader.readLine();
            poketmons.put(String.valueOf(i), poketmon);
            keys.put(poketmon, String.valueOf(i));
        }

        problems = new String[m];
        for (int i = 0; i < m; i++) {
            problems[i] = bufferedReader.readLine();
        }
    }

}
