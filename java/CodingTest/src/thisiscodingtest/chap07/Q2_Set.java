package thisiscodingtest.chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Q2_Set {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashSet<Integer> hs = new HashSet<>();
        for (String s : br.readLine().split(" ")) {
            hs.add(Integer.parseInt(s));
        }
        int m = Integer.parseInt(br.readLine());
        for (String s : br.readLine().split(" ")) {
            System.out.print(hs.contains(Integer.parseInt(s)) ? "yes " : "no ");
        }

        br.close();
    }
}
