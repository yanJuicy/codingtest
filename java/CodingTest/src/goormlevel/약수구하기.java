package goormlevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 약수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = Integer.parseInt(input);

        for (int i=1; i<=n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

}
