T = int(input())

for t in range(T):
    n, m = map(int, input().split())
    l = list(map(int, input().split()))
    array = [[0] * m for _ in range(n)]
    idx = 0
    for i in range(n):
        for j in range(m):
            array[i][j] = l[idx]
            idx += 1
    dp = [[0] * m for _ in range(n)]
    for i in range(n):
        dp[i][0] = array[i][0]

    for i in range(1, m):
        for j in range(n):
            if j == 0:
                dp[j][i] = max(dp[j][i-1], dp[j+1][i-1]) + array[j][i]
            elif j == n-1:
                dp[j][i] = max(dp[j][i-1], dp[j-1][i-1]) + array[j][i]
            else:
                dp[j][i] = max(dp[j][i-1], max(dp[j+1][i-1], dp[j-1][i-1])) + array[j][i]
    
    maxValue = 0    
    for i in range(n):
        maxValue = max(maxValue, dp[i][m-1])
    print(maxValue)