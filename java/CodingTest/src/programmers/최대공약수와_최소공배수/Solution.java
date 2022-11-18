package programmers.최대공약수와_최소공배수;

public class Solution {

    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        int lcm = lcm(n, m);

        int[] answer = {gcd, lcm};
        return answer;
    }

    private int gcd(int n, int m) {
        if (m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }

    private int lcm(int n, int m) {
        return n * m / gcd(n, m);
    }

}
