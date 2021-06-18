n = int(input())
array = list(map(int, input().split()))

d = [0] * n

d[0] = array[0]
d[1] = max(array[0], array[1])
for i in range(2, n):
    d[i] = max(d[i-1], array[i] + d[i-2])

print(d[n-1])

d = [0] * n
def solve(n):
    if d[n] != 0: return d[n]
    if n == 0: return array[0]
    if n == 1: return max(array[0], array[1])

    result = max(array[n] + solve(n - 2), solve(n-1))
    d[n] = result
    return result

print(solve(n-1))