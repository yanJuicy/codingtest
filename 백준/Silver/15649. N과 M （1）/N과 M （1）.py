def backtracking(depth):
    if depth == m:
        print(*answer)
        return
    for i in range(1, n + 1):
        if check[i]:
            continue

        answer.append(i)
        check[i] = True
        backtracking(depth + 1)
        answer.pop()
        check[i] = False


answer = []

n, m = map(int, input().split())

check = [0] * (n + 1)

backtracking(0)
