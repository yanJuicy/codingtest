package pooshapman.graph;

public class Basic_dfs {
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
                    dfs(grid, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    private static void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int[] dir : dirs) {
            int nx = i + dir[0];
            int ny = j + dir[1];

            if (nx >= 0 && nx < grid.length && ny >=0 && ny < grid[nx].length && grid[nx][ny] == '1') {
                dfs(grid, nx, ny);
            }
        }
    }
}
