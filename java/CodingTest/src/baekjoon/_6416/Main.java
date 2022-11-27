package baekjoon._6416;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Set<Integer> destinations = new HashSet<>();
        Map<Integer, Integer> edges = new HashMap<>();
        boolean isTree = true;
        int k = 1;

        while (true) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (u < 0 && v < 0) {
                break;
            }

            if (u == 0 && v == 0) {
                int rootCnt = 0;
                for (int vertex : edges.keySet()) {
                    if (!destinations.contains(vertex)) {
                        rootCnt++;
                    }
                }

                if (rootCnt != 1) {
                    isTree = false;
                }
                if (destinations.isEmpty()) {
                    isTree = true;
                }

                if (isTree) {
                    sb.append("Case ").append(k++).append(" is a tree.\n");
                } else {
                    sb.append("Case ").append(k++).append(" is not a tree.\n");
                }
                destinations.clear();
                edges.clear();
                isTree = true;
                continue;
            }

            if (!destinations.add(v)) {
                isTree = false;
            }
            edges.put(u, v);
        }

        System.out.println(sb.toString());
    }

}
