import sys
from itertools import combinations

input = sys.stdin.readline

while True:
    inputs = list(map(int, input().split()))
    k = inputs[0]
    s = inputs[1:]

    for i in combinations(s, 6):
        print(*i)

    if k == 0:
        break
    print()
