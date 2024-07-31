t = int(input())

for _ in range(t):
    n = int(input())
    d = {}
    for _ in range(n):
        clothes, category = input().split()
        if category not in d:
            d[category] = 1
        else:
            d[category] += 1

    result = 1
    for key in d.keys():
        result *= (d[key] + 1)
    result -= 1

    print(result)