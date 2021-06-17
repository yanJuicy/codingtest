package pooshapman.graph;

public class Basic_dfs01 {

    static int n = 3;
    static int m = 3;

    public static void main(String[] args) {
        int[][] grid = {
                { 9, 8, 3 },
                { 6, 5, 7 },
                { 2, 1, 1 }};

        System.out.println((solve(grid)));
    }

    private static int solve(int[][] grid) {
        int[][] result = new int[n][m];
        int cnt = 1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int len = dfs(grid, result, i, j);
                cnt = Math.max(cnt, len);
            }
        }

        return cnt;
    }

    private static int dfs(int[][] grid, int[][] result, int i, int j) {
        if (result[i][j] != 0)
            return result[i][j];

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int maxLen = 1;
        for (int[] dir : dirs) {
            int nx = i + dir[0];
            int ny = j + dir[1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[i][j] >= grid[nx][ny])
                continue;

            int len = 1 + dfs(grid, result, nx, ny);
            maxLen = Math.max(len, maxLen);
        }
        result[i][j] = maxLen;

        return maxLen;
    }
}
