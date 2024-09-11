def backtracking(depth):
    if depth == m:
        print(*answer)
        return
    for i in range(1, n + 1):
        answer.append(i)
        backtracking(depth + 1)
        answer.pop()


answer = []

n, m = map(int, input().split())

backtracking(0)
