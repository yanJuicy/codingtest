result = sum([1, 2, 3, 4, 5])
print(result)

result = min(7, 3, 5, 2)
print(result)

result = max(7, 3, 5, 2)
print(result)

result = eval("(3 + 5) * 7")
print(result)

result = sorted([9, 1, 8, 5, 4])
print(result)
result = sorted([9, 1, 8, 5, 4], reverse=True)
print(result)
result = sorted([('홍길동', 35), ('이순신', 75), ('아무개', 50)], key=lambda x: x[1], reverse=True)
print(result)

data = [9, 1, 8, 5, 4]
data.sort()
print(data)

from itertools import permutations

data = ['A', 'B', 'C']
result = list(permutations(data, 3))
print(result)

from itertools import combinations

data = ['A', 'B', 'C']
result = list(combinations(data, 2))
print(result)

from itertools import product

data = ['A', 'B', 'C']
result = list(product(data, repeat=2))
print(result)

from itertools import combinations_with_replacement

data = ['A', 'B', 'C']
result = list(combinations_with_replacement(data, 2))
print(result)

from bisect import bisect_left, bisect_right

a = [1, 2, 4, 4, 8]
x = 4

print(bisect_left(a, x))
print(bisect_right(a, x))


def count_by_range(a, left_value, right_value):
    right_index = bisect_right(a, right_value)
    left_index = bisect_left(a, left_value)
    return right_index - left_index

a = [1, 2, 3, 3, 3, 3, 4, 4, 8, 9]

print(count_by_range(a, 4, 4,))

print(count_by_range(a, -1, 3))

from collections import deque

data = deque([2, 3, 4])
data.appendleft(1)
data.append(5)

print(data)
print(list(data))

from collections import Counter

counter = Counter(['red', 'blue', 'red', 'green', 'blue', 'blue'])
print(counter['blue'])
print(counter['reg'])
print(counter['green'])
print(dict(counter))

import math
print(math.factorial(5))

print(math.sqrt(7))

print(math.gcd(21, 14))

print(math.pi)
print(math.e)
