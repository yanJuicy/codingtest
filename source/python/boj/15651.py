n, m = map(int, input().split())

check = [0] * (n + 1)

def solve(step):
    if step == m:
        for i in range(m):
            print(check[i], end=' ')
        print()
        return
    
    for i in range(1, n+1):
        check[step] = i
        solve(step + 1)

solve(0)