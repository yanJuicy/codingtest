from collections import deque


def bfs():
    dy = [1, -1, 0, 0]
    dx = [0, 0, 1, -1]
    q = deque([[0, 0, 0]])
    visited = [[[0] * 2 for _ in range(m)] for _ in range(n)]
    visited[0][0][0] = 1

    while q:
        y, x, wall = q.popleft()
        if y == n - 1 and x == m - 1:
            return visited[y][x][wall]

        for d in range(4):
            next_y = y + dy[d]
            next_x = x + dx[d]
            if (
                0 <= next_y < n
                and 0 <= next_x < m
                and visited[next_y][next_x][wall] == 0
            ):
                if graph[next_y][next_x] == 0:
                    visited[next_y][next_x][wall] = visited[y][x][wall] + 1
                    q.append([next_y, next_x, wall])
                if wall == 0 and graph[next_y][next_x] == 1:
                    visited[next_y][next_x][1] = visited[y][x][0] + 1
                    q.append([next_y, next_x, 1])

    return -1


n, m = map(int, input().split())
graph = [list(map(int, input())) for _ in range(n)]

print(bfs())
