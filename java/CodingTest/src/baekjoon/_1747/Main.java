package baekjoon._1747;

import java.util.Scanner;

public class Main {

    private static int n;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        boolean[] notPrime = new boolean[1000001];
        notPrime[0] = notPrime[1] = true;

        for (int i = 2; i * i < notPrime.length; i++) {
            if (notPrime[i]) {
                continue;
            }

            for (int j = i + i; j < notPrime.length; j += i) {
                notPrime[j] = true;
            }
        }

        int result = 0;
        for (int i = n; i < notPrime.length; i++) {
            if (!notPrime[i] && isPalindrome(i)) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    private static boolean isPalindrome(int prime) {
        char[] temp = String.valueOf(prime).toCharArray();

        int s = 0;
        int e = temp.length - 1;

        while (s < e) {
            if (temp[s] != temp[e]) {
                return false;
            }

            s++;
            e--;
        }

        return true;
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }

}
