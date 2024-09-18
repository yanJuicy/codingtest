from collections import deque


def bfs():
    global answer
    bfs_visited = [[0 for _ in range(m)] for _ in range(n)]
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    q = deque()

    for i in range(n):
        for j in range(m):
            if lab[i][j] == 2:
                q.append([i, j])
                bfs_visited[i][j] = 1

    while q:
        r, c = q.popleft()

        for d in range(4):
            next_r = r + dy[d]
            next_c = c + dx[d]
            if (
                0 <= next_r < n
                and 0 <= next_c < m
                and not lab[next_r][next_c]
                and not bfs_visited[next_r][next_c]
            ):
                q.append([next_r, next_c])
                bfs_visited[next_r][next_c] = 1

    cnt = 0
    for i in range(n):
        for j in range(m):
            if not lab[i][j] and not bfs_visited[i][j]:
                cnt += 1

    answer = max(answer, cnt)


def backtracking(wall_count):
    if wall_count == 3:
        bfs()
        return

    for i in range(n):
        for j in range(m):
            if not lab[i][j] and not backtracking_visited[i][j]:
                backtracking_visited[i][j] = 1
                lab[i][j] = 1
                backtracking(wall_count + 1)
                backtracking_visited[i][j] = 0
                lab[i][j] = 0


answer = 0
n, m = map(int, input().split())
lab = [list(map(int, input().split())) for _ in range(n)]
backtracking_visited = [[0 for _ in range(m)] for _ in range(n)]

backtracking(0)
print(answer)
