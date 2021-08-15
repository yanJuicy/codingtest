def getTiles(row, col, step):
    cnt = 0
    for i in range(row, row+step):
        for j in range(col, col+step):
            if s[i][j] == 1:
                cnt += 1
    return cnt

T = int(input())
for _ in range(T):
    N, K = map(int, input().split())
    s = []
    for _ in range(N):
        s.append(list(map(int, input().split())))
    cnt = 987654321
    for i in range(N - K + 1):
        for j in range(N - K + 1):
            cnt = min(cnt, getTiles(i, j, K))
    print(cnt)