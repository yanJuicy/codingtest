n = int(input())
l = list(map(int, input().split()))
l.sort()

minValue = 1
for x in l:
    if minValue < x:
        break
        minValue += x

print(minValue)