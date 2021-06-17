n = int(input())
members = list(map(int, input().split()))

d = dict()

for i in members:
    if d.get(i) == None:
        d[i] = 1
    else:
        d[i] += 1

result = 0

for i in d.keys():
    val = d[i]
    result += val // i

print(result)
