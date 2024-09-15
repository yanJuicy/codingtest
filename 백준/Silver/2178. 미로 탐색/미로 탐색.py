from collections import deque


def bfs(x, y):
    cnt = 0
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    q = deque([[0, 0]])
    maze[y][x] = 0

    while len(q) > 0:
        level = len(q)
        cnt += 1
        for _ in range(level):
            cur_y, cur_x = q.popleft()

            if cur_y == n - 1 and cur_x == m - 1:
                return cnt

            for i in range(4):
                next_y = cur_y + dy[i]
                next_x = cur_x + dx[i]
                if 0 <= next_y < n and 0 <= next_x < m and maze[next_y][next_x] == 1:
                    q.append([next_y, next_x])
                    maze[next_y][next_x] = 0


n, m = map(int, input().split())
maze = []
for _ in range(n):
    maze.append([int(x) for x in input()])

print(bfs(0, 0))
