package programmers.소수_찾기;

public class Solution {

    public int solution(int n) {
        boolean[] notPrimes = new boolean[n + 1];
        primeEratostenes(notPrimes, n);

        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (!notPrimes[i]) {
                answer++;
            }
        }

        return answer;
    }


    private boolean[] primeEratostenes(boolean[] notPrimes, int n) {
        notPrimes[1] = true;

        for (int i = 2; i <= n; i++) {
            if (notPrimes[i] == true) {
                continue;
            }

            for (int j = i + i; j <= n; j += i) {
                notPrimes[j] = true;
            }
        }
        return notPrimes;
    }
}
