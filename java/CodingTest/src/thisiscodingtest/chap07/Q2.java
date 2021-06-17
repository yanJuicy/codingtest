package thisiscodingtest.chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int index = 0;
        for (String s : br.readLine().split(" ")) {
            arr[index++] = Integer.parseInt(s);
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        int[] targets = new int[m];
        index = 0;
        for (String s : br.readLine().split(" ")) {
            targets[index++] = Integer.parseInt(s);
        }

        for (int target : targets) {
            System.out.print(binarySearch(arr, target, 0, n-1) ? "yes " : "no ");
        }

        br.close();
    }

    private static boolean binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) return false;

        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return true;
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, left, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, right);
        }
    }
}
