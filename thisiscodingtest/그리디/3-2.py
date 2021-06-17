n, m, k = map(int, input().split())
data = list(map(int, input().split()))

"""
1. 내림차순 정렬을 한다
2. 0번째를 k번 뽑고 1번째를 1번 뽑고 다시 0번째를 k번 뽑는다.
3. 2번 과정을 M번 동안 한다.
"""
data.sort(reverse=True)
result = 0
cnt = 0

for i in range(m):
    if cnt < k:
        result += data[0]
        cnt += 1
    else:
        result += data[1]
        cnt = 0

print(result)