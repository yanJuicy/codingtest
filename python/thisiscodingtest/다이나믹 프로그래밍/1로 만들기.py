x = int(input())
d = [0] * (x+1)

def solve(x):
    if x == 1: return 0
    if d[x] != 0: return d[x]

    result = solve(x-1) + 1
    if x % 2 == 0: result = min(solve(x//2) + 1, result)
    if x % 3 == 0: result = min(solve(x//3) + 1, result)
    if x % 5 == 0: result = min(solve(x//5) + 1, result)

    d[x] = result
    return result

print(solve(x))

d = [0] * (x+1)
for i in range(2, x + 1):
    d[i] = d[i - 1] + 1
    if i % 2 == 0:
        d[i] = min(d[i//2]+1, d[i])
    if i % 3 == 0:
        d[i] = min(d[i//3]+1, d[i])
    if i % 5 == 0:
        d[i] = min(d[i//5]+1, d[i])
print(d[x])
