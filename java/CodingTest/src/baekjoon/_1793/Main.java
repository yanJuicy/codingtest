package baekjoon._1793;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger[] d = new BigInteger[251];
        d[0] = new BigInteger("1");
        d[1] = new BigInteger("1");
        d[2] = new BigInteger("3");

        for (int i=3; i<=250; i++) {
            d[i] = d[i-1].add(d[i-2].multiply(new BigInteger("2")));
        }

        while (sc.hasNext()) {
            System.out.println(d[sc.nextInt()]);
        }

    }
}
