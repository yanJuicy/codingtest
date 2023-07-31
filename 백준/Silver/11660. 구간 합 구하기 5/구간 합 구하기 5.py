import sys
input = sys.stdin.readline

n, m = map(int, input().split())
a = []
for _ in range(n):
    a.append(list(map(int, input().split())))

s = [[0 for j in range(n + 1)] for i in range(n + 1)]
for i in range(1, n + 1):
    for j in range(1, n + 1):
        s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + a[i - 1][j - 1]


def solve(x1, y1, x2, y2):
    return s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1]


for _ in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    print(solve(x1, y1, x2, y2))
