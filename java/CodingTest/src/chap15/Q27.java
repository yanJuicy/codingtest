package chap15;

import java.util.Scanner;

public class Q27 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solve(arr, n, x));
    }

    private static int solve(int[] arr, int n, int x) {
        int right = find_right(arr, x, 0, n);
        int left = find_left(arr, x, 0, n);

        if (right == -1) return -1;
        return right - left + 2;
    }

    private static int find_left(int[] arr, int x, int left, int right) {
        int result = -1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static int find_right(int[] arr, int x, int left, int right) {
        int result = -1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

}
