from itertools import combinations_with_replacement

rome_numbers = [1, 5, 10, 50]

n = int(input())
s = set()

for num_tuple in combinations_with_replacement(rome_numbers, n):
    s.add(sum(num_tuple))

print(len(s))
