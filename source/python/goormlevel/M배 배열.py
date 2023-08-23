n, m = map(int, input().split())
a = list(map(int, input().split()))

a = [i * m if i % m != 0 else i for i in a]
for i in a:
    print(i, end=' ')