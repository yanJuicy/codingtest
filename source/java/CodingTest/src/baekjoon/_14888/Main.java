package baekjoon._14888;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, max, min;
    static int[] nums, operators, order;    // order 에 연산자 순서 조합 정리
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(max + "\n" + min);
    }

    // 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
    static int calculator() {
        int value = nums[1];
        for (int i=1; i<=N-1; i++) {
            if (order[i] == 1)
                value = value + nums[i + 1];
            if (order[i] == 2)
                value = value - nums[i + 1];
            if (order[i] == 3)
                value = value * nums[i + 1];
            if (order[i] == 4)
                value = value / nums[i + 1];
        }
        return value;
    }

    // order[1...N-1]에 연산자들이 순서대로 저장될 것이다.
    static void rec_func(int k) {
        if (k == N) {
            // 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
            int value = calculator();
            max = Math.max(value, max);
            min = Math.min(value, min);
        } else {
            // k 번째 연산자는 무엇을 선택할 것인가?
            for (int cand=1; cand<=4; cand++) {
                if (operators[cand] >= 1) {
                    operators[cand]--;
                    order[k] = cand;
                    rec_func(k + 1);
                    operators[cand]++;
                    order[k] = 0;
                }
            }
        }
    }

    static void input() {
        N = scan.nextInt();
        order = new int[N + 1]; // 연산자
        nums = new int[N + 1];
        operators = new int[5];

        for (int i=1; i<=N; i++)
            nums[i] = scan.nextInt();
        for (int i=1; i<=4; i++)
            operators[i] = scan.nextInt();

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
