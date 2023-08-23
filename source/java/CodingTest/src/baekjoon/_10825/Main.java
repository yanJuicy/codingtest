package baekjoon._10825;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static Elem elem[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
        System.out.println(sb.toString());
    }

    private static void solve() {
        Arrays.sort(elem);
        for (Elem el : elem) {
            sb.append(el.name + "\n");
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        elem = new Elem[N];
        for (int i=0; i<N; i++) {
            String name = sc.next();
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int math = sc.nextInt();
            elem[i] = new Elem(name, kor, eng, math);
        }
    }

    static class Elem implements Comparable<Elem> {

        String name;
        int kor, eng, math;

        public Elem(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Elem o) {
            if (this.kor != o.kor) return o.kor - this.kor;
            if (this.eng != o.eng) return this.eng - o.eng;
            if (this.math !=  o.math) return o.math - this.math;
            return this.name.compareTo(o.name);
        }
    }
}
