package baekjoon._11866;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> peo = new ArrayList<>();
        for (int i = 1; i<= N; i++) {
            peo.add(i);
        }

        StringBuilder answer = new StringBuilder();
        answer.append("<");
        int pt = 0;

        for (int i=0; i<N; i++) {
            pt += K - 1;
            pt %= peo.size();
            answer.append(peo.get(pt) + ", ");
            peo.remove(pt);
        }

        answer.replace(answer.length() -2 , answer.length(), ">");
        System.out.println(answer.toString());
    }

}
