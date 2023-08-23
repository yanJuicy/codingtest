a, b, v = map(int, input().split())
result = int((v - b - 1) / (a - b)) + 1
print(result)
