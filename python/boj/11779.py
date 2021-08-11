import heapq
n = int(input())
m = int(input())

graph = [[] for _ in range(n + 1)]
INF = int(1e9)
dist = [INF] * (n + 1)
parent = [i for i in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

start, end = map(int, input().split())

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    dist[start] = 0

    while q:
        distance, now = heapq.heappop(q)
        if dist[now] < distance:
            continue
        for i in graph[now]:
            cost = distance + i[1]
            if cost < dist[i[0]]:
                dist[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
                parent[i[0]] = now
        
dijkstra(start)
print(dist[end])
st = []
cnt = 1
i = end
st.append(i)
while i != start:
    i = parent[i]
    cnt += 1
    st.append(i)

print(cnt)
while st:
    print(st.pop(), end=' ')