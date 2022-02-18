package programmers.카카오_프렌즈_컬러링북;

public class Solution {
    boolean[][] visited;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int size;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    size = 0;
                    dfs(i, j, picture, picture[i][j], m, n);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private void dfs(int m, int n, int[][] picture, int x, int mLength, int nLength) {
        visited[m][n] = true;
        size++;

        for (int i = 0; i < 4; i++) {
            int nm = m + dx[i];
            int nn = n + dy[i];

            if (nm < 0 || nm >= mLength || nn < 0 || nn >= nLength)
                continue;

            if (!visited[nm][nn] && picture[nm][nn] == x)
                dfs(nm, nn, picture, x, mLength, nLength);
        }
    }
}
