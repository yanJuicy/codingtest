n, m, k, x = map(int, input().split())

graph = [[] for i in range(n + 1)]
visited = [False] * (n + 1)

for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

result = []

from collections import deque

def bfs(s, level):
    q = deque()
    q.append(s)
    visited[s] = True

    while q:
        length = len(q)

        while length > 0:
            length -= 1
            cur = q.popleft()

            if level == 0:
                result.append(cur)

            for nextNode in graph[cur]:
                if not visited[nextNode]:
                    q.append(nextNode)
                    visited[nextNode] = True
        level -= 1


bfs(x, k)

if len(result) == 0: print(-1)
else: 
    sorted(result)
    for i in result:
        print(i)
