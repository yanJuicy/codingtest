package baekjoon._1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int n, m, known;
    private static int[] people;
    private static ArrayList<Integer>[] party;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        int result = m;

        for (int i = 0; i < m; i++) {
            int first = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(first - 1, party[i].get(j) - 1, p);
            }
        }

        for (int i = 0; i < people.length; i++) {
            people[i] = find(people[i], p);
        }

        for (int i = 0; i < party.length; i++) {
            int parent = find(party[i].get(0) - 1, p);
            for (int j = 0; j < people.length; j++) {
                if (parent == people[j]) {
                    result--;
                    break;
                }
            }
        }

        System.out.println(result);
    }

    private static void union(int a, int b, int[] p) {
        a = find(a, p);
        b = find(b, p);
        p[b] = a;
    }

    private static int find(int x, int[] p) {
        if (x == p[x]) {
            return x;
        }
        return find(p[x], p);
    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bufferedReader.readLine());
        known = Integer.parseInt(st.nextToken());

        people = new int[known];
        for (int i = 0; i < known; i++) {
            people[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        party = new ArrayList[m];
        for (int i = 0; i < party.length; i++) {
            party[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }
    }

}
