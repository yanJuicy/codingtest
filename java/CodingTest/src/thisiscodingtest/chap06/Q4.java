package thisiscodingtest.chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(a);
        Collections.sort(b, (o1, o2) -> o2 - o1);

        for (int i=0; i<k; i++) {
            if (a.get(i) < b.get(i)) {
                a.set(i, b.get(i));
            } else {
                break;
            }
        }

        int result = 0;
        for (int num : a) {
            result += num;
        }

        System.out.println(result);

        br.close();
    }

}
