def dfs(cur, n, computers, visited):
    visited[cur] = True
    
    for next in range(n):
        if computers[cur][next] == 1 and not visited[next]:
            dfs(next, n, computers, visited)
        

def solution(n, computers):
    answer = 0
    
    visited = [False] * n
    
    for i in range(n):
        for j in range(n):
            if not visited[i]:
                dfs(i, n, computers, visited)
                answer += 1
    
    return answer