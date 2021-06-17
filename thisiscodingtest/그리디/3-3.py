
n, m = map(int, input().split())

result = 0

for i in range(n):
    nums = list(map(int, input().split()))
    mv = min(nums)
    if result < mv:
        result = mv

print(result)
