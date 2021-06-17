
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sample_input.txt"));

        int t = Integer.parseInt(br.readLine());
        for (int x = 1; x <= t; x++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> right = new ArrayList<>();
            while (st.hasMoreTokens()) {
                right.add(Integer.valueOf(st.nextToken()));
            }

            Collections.sort(right);
            System.out.println("#" + x + " " + solve(right));
        }
        br.close();
    }

    private static int solve(ArrayList<Integer> right) {
        ArrayList<Integer> left = new ArrayList<>();
        int result = 0;

        boolean isStop = false;
        boolean isReverse = false;

        while (true) {
            int cost = 0;
            for (int i=0; i<2; i++) {
                cost = Math.max(cost, right.get(0));
                left.add(right.get(0));
                right.remove(0);

                if (right.isEmpty()) {
                    isStop = true;
                    break;
                }
            }
            result += cost;
            if (isStop) break;
            Collections.sort(left);

            right.add(left.get(0));
            result += left.get(0);
            left.remove(0);
            Collections.sort(right);

            if (!isReverse)
                Collections.reverse(right);
            isReverse = !isReverse;
        }

        return result;
    }
}

