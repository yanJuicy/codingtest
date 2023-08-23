package baekjoon._15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	private static int n, m, result;
	private static ArrayList<int[]> houses, chickens, visit;

	public static void main(String[] args) throws IOException {
		input();
		solve();
	}

	private static void solve() {
		back(0, 0);
		System.out.println(result);
	}

	private static void back(int depth, int start) {
		if (depth == m) {
			int sum = 0;
			for (int[] houseCoord : houses) {
				int min = Integer.MAX_VALUE;
				for (int[] chickenCoord : visit) {
					min = Math.min(min, getDist(houseCoord, chickenCoord));
				}
				sum += min;
			}
			result = Math.min(result, sum);
			return;
		}

		for (int i = start; i < chickens.size(); i++) {
			visit.add(chickens.get(i));
			back(depth + 1, i + 1);
			visit.remove(chickens.get(i));
		}
	}

	private static int getDist(int[] coord1, int[] coord2) {
		return Math.abs(coord1[0] - coord2[0]) + Math.abs(coord1[1] - coord2[1]);
	}

	private static void input() throws IOException {
		houses = new ArrayList<>();
		chickens = new ArrayList<>();
		visit = new ArrayList<>();

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] split = bufferedReader.readLine().split(" ");
		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);
		result = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			split = bufferedReader.readLine().split(" ");
			for (int j = 0; j < split.length; j++) {
				if (split[j].equals("1")) {
					houses.add(new int[]{i, j});
				}
				if (split[j].equals("2")) {
					chickens.add(new int[]{i, j});
				}
			}
		}
	}

}
