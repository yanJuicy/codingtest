n = int(input())

time = [0] * (n + 1)
indegree = [0] * (n + 1)

graph = [[] for _ in range(n + 1)]

for i in range(1, n + 1):
    data = list(map(int, input().split()))
    time[i] = data[0]
    for x in data[1:-1]:
        indegree[i] += 1
        graph[x].append(i)

from collections import deque
import copy
def topology_sort():
    q = deque()
    result = copy.deepcopy(time)

    for i in range(1, n + 1):
        if indegree[i] == 0:
            q.append(i)
    
    while q:
        now = q.popleft()
        
        for nextNode in graph[now]:
            result[nextNode] = max(result[nextNode], result[now] + time[nextNode])
            indegree[nextNode] -= 1
            if indegree[nextNode] == 0:
                q.append(nextNode)

    for i in range(1, n+1):
        print(result[i])

topology_sort()
            



