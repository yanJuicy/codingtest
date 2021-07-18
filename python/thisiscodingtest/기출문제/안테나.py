n = int(input())
l = list(map(int, input().split()))

l.sort()
length = len(l)

if length % 2:
    print(l[length // 2])
else:
    print(l[length // 2 - 1])
