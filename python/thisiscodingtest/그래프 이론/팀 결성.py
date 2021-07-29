n, m = map(int, input().split())

parent = [i for i in range(n + 1)]

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

def isSameTeam(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a == b: return "YES"
    else: return "NO"

for _ in range(m):
    op, a, b = map(int, input().split())
    if op == 0:
        union(parent, a, b)
    else:
        print(isSameTeam(parent, a, b))