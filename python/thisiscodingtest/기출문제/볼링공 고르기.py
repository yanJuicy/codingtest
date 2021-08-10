n, m = map(int, input().split())
l = list(map(int, input().split()))

weights = [0] * 11
for x in l:
    weights[x] += 1

result = 0
for i in range(1, m + 1):
    n -= weights[i]
    result += weights[i] * n

print(result)
