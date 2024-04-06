def find(parent, i):
    if parent[i] == i:
        return i
    parent[i] = find(parent, parent[i])
    return parent[i]
    
def union(parent, x, y):
    x_root = find(parent, x)
    y_root = find(parent, y)
    parent[y_root] = x_root

def solution(n, costs):
    answer = 0
    
    costs.sort(key=lambda x : x[2])
    
    parent = [i for i in range(n)]
    
    edges = 0
    
    for edge in costs:
        if edges == n - 1:
            break
        
        x = find(parent, edge[0])
        y = find(parent, edge[1])
        
        if x != y:
            union(parent, x, y)
            edges += 1
            answer += edge[2]

    return answer