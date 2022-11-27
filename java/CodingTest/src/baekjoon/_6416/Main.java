package baekjoon._6416;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Set<Integer> destinations = new HashSet<>();
        Set<Integer> departures = new HashSet<>();
        boolean isTree = true;
        int k = 1;

        while (true) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (u < 0 && v < 0) {
                break;
            }

            if (u == 0 && v == 0) {
                if (departures.isEmpty()) {
                    sb.append("Case ").append(k++).append(" is a tree.\n");
                    continue;
                }

                int rootCnt = 0;
                for (int vertex : departures) {
                    if (!destinations.contains(vertex)) {
                        rootCnt++;
                    }
                }

                if (rootCnt != 1) {
                    isTree = false;
                }

                sb.append("Case ").append(k++);
                if (isTree) {
                    sb.append(" is a tree.\n");
                } else {
                    sb.append(" is not a tree.\n");
                }
                destinations.clear();
                departures.clear();
                isTree = true;
                continue;
            }

            if (!destinations.add(v)) {
                isTree = false;
            }
            departures.add(u);
        }

        System.out.println(sb.toString());
    }

}
