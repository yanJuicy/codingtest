import java.util.Scanner;

public class A {
    public static final Scanner scanner = new Scanner(System.in);
	/**
     * 생일이 m월인 가장 큰 키의 도토리를 찾는 함수
     * @param height  각 도토리의 키
     * @param month   각 도토리의 출생 월
     * @param n   도토리의 수
     * @param m   찾고자 하는 달
     * @return    month[k] == m인 가장 큰 height[k]
     */
	public static int getMaximumHeight(int[] height, int[] month, int n, int m)
	{
        int maxHeight = -1;
        for (int i=n-1; i>=0; i--) {
            if (m == month[i]) {
                maxHeight = height[i];
                break;
            }
        }

        return maxHeight;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		int[] height = new int[n];
		int[] month = new int[n];

		for(int i = 0 ; i < n ; i ++)
		{
			height[i] = scanner.nextInt();
		}
		for (int i = 0; i < n; i++) {
			month[i] = scanner.nextInt();
		}

		int m = scanner.nextInt();

		int answer = getMaximumHeight(height, month, n, m);

		System.out.println(answer);
	}
}
