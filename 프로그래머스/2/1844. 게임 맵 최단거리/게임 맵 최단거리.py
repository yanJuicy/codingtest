def bfs(row, col, maps):
    q = [[row, col]]
    
    dist = [[-1] * len(maps[0]) for _ in range(len(maps))]
    dist[row][col] = 1
    
    while q: 
        cur = q.pop(0)
        for d in range(4):
            dx = [0, 0, 1, -1]
            dy = [1, -1, 0, 0]
            next_row = cur[0] + dy[d]
            next_col = cur[1] + dx[d]
            
            if next_row < 0 or next_row >= len(maps) or next_col < 0 or next_col >= len(maps[0]):
                continue
            
            if dist[next_row][next_col] == -1 and maps[next_row][next_col] == 1:
                q.append([next_row, next_col])
                dist[next_row][next_col] = dist[cur[0]][cur[1]] + 1
    
    return dist
    

def solution(maps):
    answer = bfs(0, 0, maps)
    return answer[len(maps) - 1][len(maps[0]) - 1]