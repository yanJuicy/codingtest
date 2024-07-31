def clothes_count(d):
    n = len(d)
    if n == 0:
        return 0
    result = 1
    for key in d.keys():
        result *= (d[key] + 1)
    return result - 1

test_case = int(input())
while test_case:
    n = int(input())
    clothes = set()
    kind = dict()
    for j in range(n):
        wear = input()
        a, b = wear.split()
        if b not in clothes:
            clothes.add(b)
            kind[b] = 1
        else:
            kind[b] += 1
    result = clothes_count(kind)
    print(result)
    test_case -= 1