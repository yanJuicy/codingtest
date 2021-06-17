from collections import deque

n, m = map(int, input().split())

graph = []
for i in range(n):
    graph.append(list(map(int, input())))

d = [(1, 0), (-1, 0), (0, 1), (0, -1)]

def dfs(x, y):
    if x < 0 or x >= n or y < 0 or y >= m or graph[x][y] == 1:
        return
    graph[x][y] = 1
    for i in d:
        dfs(x + i[0], y + i[1])

def bfs(x, y):
    q = deque([(x, y)])
    while q:    # q에 뭔가 있으면 반복한다
        v = q.popleft()
        cx = v[0]   # 현재 좌표 x
        cy = v[1]   # 현재 좌표 y
        
        # 현재 좌표에서 어떠한 처리를 한다
        graph[cx][cy] = 1

        # 다음에 방문할 좌표를 큐에 넣는다
        for i in d:
            nx = cx + i[0]  # 다음 좌표 x
            ny = cy + i[1]  # 다음 좌표 y
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if graph[nx][ny] == 0:
                q.append((nx, ny))
                graph[nx][ny] = 1


result = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            bfs(i, j)
            result += 1

print(result)