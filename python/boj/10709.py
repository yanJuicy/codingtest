h, w = map(int, input().split())
graph = []

for _ in range(h):
    graph.append(input())

for i in range(h):
    cloudIdx = -1
    for j in range(w):
        if graph[i][j] == 'c':
            print(0, end=' ')
            cloudIdx = j
        else:
            if cloudIdx == -1:
                print(-1, end=' ')
            else:
                print(j - cloudIdx, end=' ')
    print()

