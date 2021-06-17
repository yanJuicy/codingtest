package pooshapman.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Basic_bfs03 {

    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 0, 3, 3 },
                { 1, 4, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 2, 2, 0 },
                { 1, 1, 0, 0 } };

        int[] result = solution(grid);
        for (int i : result) {
            System.out.println("i: " + i);
        }
    }

    private static int[] solution(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visit = new boolean[n][m];
        int cnt = 0;
        int areaSize = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] != 0 && !visit[i][j]) {
                    areaSize = Math.max(bfs(i, j, grid, visit, n, m), areaSize);
                    cnt++;
                }
            }
        }

        return new int[] {cnt, areaSize};
    }

    private static int bfs(int i, int j, int[][] grid, boolean[][] visit, int n, int m) {
        visit[i][j] = true;

        int[] pos = {i, j};
        Queue<int[]> q = new LinkedList<>();
        q.offer(pos);

        int areaSize = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            areaSize++;

            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if (grid[nx][ny] == grid[cur[0]][cur[1]] && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return areaSize;
    }


}
