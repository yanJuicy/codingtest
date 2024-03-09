def bfs(row, col, visit, max_row, max_col, maps):
    visit_L = False
    
    q = []
    visit[row][col] = True
    q.append([row, col, 0])
    
    while q:
        cur_row, cur_col, step = q.pop(0)

        if maps[cur_row][cur_col] == "E" and visit_L:
            return step

        if maps[cur_row][cur_col] == "L":
            visit_L = True
            visit = [[False for _ in range(len(maps[0]))] for _ in range(len(maps))]
            visit[cur_row][cur_col] = True
            q = []

        for d in range(4):
            d_row = [1, -1, 0, 0]
            d_col = [0, 0, 1, -1]
            next_row = cur_row + d_row[d]
            next_col = cur_col + d_col[d]

            if next_row < 0 or next_row >= max_row or next_col < 0 or next_col >= max_col:
                continue

            if maps[next_row][next_col] != "X" and not visit[next_row][next_col] :
                q.append([next_row, next_col, step + 1])
                visit[next_row][next_col] = True
        
        step += 1
    
    return -1
    

def solution(maps):
    visit = [[False for _ in range(len(maps[0]))] for _ in range(len(maps))]
    
    for i in range(len(maps)):
        for j in range(len(maps[i])):
            if maps[i][j] == "S":
                answer = bfs(i, j, visit, len(maps), len(maps[0]), maps)
                return answer
