package pooshapman.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Basic_bfs {
    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '1' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' },
                { '0', '0', '0', '1', '1' } };

        System.out.println((solve(grid)));
    }

    private static int solve(char[][] grid) {
        int result = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    static void bfs(char[][]grid, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});

        int[][] dirs = {{1,0}, {0,1}, {-1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            int[] point = q.poll();

            for (int[] dir: dirs) {
                int nx = point[0] + dir[0];
                int ny = point[1] + dir[1];

                if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid.length && grid[nx][ny] == '1') {
                    grid[nx][ny] = '0';
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
