n, m = map(int, input().split())

edges = []
parent = [i for i in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    edges.append((c, a, b))

edges.sort()

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

result = 0
maxEdge = 0

for e in edges:
    cost, start, end = e
    if find_parent(parent, start) != find_parent(parent, end):
        union(parent, start, end)
        result += cost
        maxEdge = cost

print(result - maxEdge)

