n = int(input())

d = [[0] * n for _ in range(n)]
data = []
for _ in range(n):
    data.append(list(map(int, input().split())))

d[0][0] = data[0][0]
for i in range(1, n):
    for j in range(len(data[i])):
        if j == 0:
            d[i][j] += d[i-1][j] + data[i][j]
        elif j == len(d[i]) - 1:
            d[i][j] += d[i-1][j-1] + data[i][j]
        else:
            d[i][j] += max(d[i-1][j-1], d[i-1][j]) + data[i][j]

print(max(d[n-1]))