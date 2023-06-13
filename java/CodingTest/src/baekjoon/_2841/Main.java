package baekjoon._2841;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	private static final int NOT_FRET = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] split = bufferedReader.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int p = Integer.parseInt(split[1]);
		Stack<Integer>[] stacks = new Stack[7];
		for (int i = 1; i <= 6; i++) {
			stacks[i] = new Stack<>();
			stacks[i].add(NOT_FRET);
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			split = bufferedReader.readLine().split(" ");
			int lineNum = Integer.parseInt(split[0]);
			int fretNum = Integer.parseInt(split[1]);

			while (stacks[lineNum].peek() > fretNum) {
				stacks[lineNum].pop();
				result++;
			}
			if (stacks[lineNum].peek() == fretNum) {
				continue;
			}
			stacks[lineNum].add(fretNum);
			result++;
		}

		System.out.println(result);
	}

}
