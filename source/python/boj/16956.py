r, c = map(int, input().split())
graph = []
for _ in range(r):
    graph.append(list(input()))

for i in range(r):
    for j in range(c):
        if graph[i][j] == '.':
            graph[i][j] = 'D'

dx = [0, 0, 1, -1]
dy = [-1, 1, 0, 0]

result = True
for i in range(r):
    for j in range(c):
        if graph[i][j] == 'W':
            for x in range(4):
                nx = i + dx[x]
                ny = j + dy[x]
                if nx < 0 or nx >= r or ny < 0 or ny >= c:
                    continue
                if graph[nx][ny] == 'S':
                    result = False

if result == False:
    print(0)
else:
    print(1)
    for i in range(r):
        for j in range(c):
            print(graph[i][j],end='')
        print()